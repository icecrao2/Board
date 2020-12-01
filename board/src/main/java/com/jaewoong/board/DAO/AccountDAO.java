package com.jaewoong.board.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jaewoong.board.DTO.AccountDTO;
import com.jaewoong.board.DTO.RegistAccountDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import VO.LoginVO;

@Component(value = "LoginDAO")
public class AccountDAO implements IAccountDAO{


	private AccountDTO getAccount(Connection conn, PreparedStatement psmt, String query, String... args) throws SQLException{

        ResultSet rs = null;		
        List<AccountDTO> dto = null;
        
    	//conn = dataSource.getConnection();
		psmt = conn.prepareStatement(query);
		
		for(int a = 0 ; a < args.length ; a++)
			psmt.setString(a+1, args[0]);
		
		rs = psmt.executeQuery();
	
		dto = wrapDataToAccountDTO(rs);
		
		closeConnection(psmt);
		
		
		if(dto.size() == 0)
			return null;
		
		return dto.get(0);
	}
	
	private boolean insertAccount(Connection conn, PreparedStatement psmt, String query, String... args) throws ParseException, SQLException{

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date birth = transFormat.parse(args[4]);
		
		//conn = dataSource.getConnection();
		psmt = conn.prepareStatement(query);
		
		for(int a = 0 ; a < args.length ; a++) {
			if(a == 3)
				psmt.setDate(4, new java.sql.Date(birth.getTime()));
			else
				psmt.setString(a+1, args[a]);
		}
		psmt.executeUpdate();

		closeConnection(psmt);
		
		return true;
	}
	
	
	private boolean insertPermission(Connection conn, PreparedStatement psmt, String query, String id, Integer permission) throws SQLException{
		
	//	conn = dataSource.getConnection();
		psmt = conn.prepareStatement(query);
		
		psmt.setString(1, id);
		psmt.setInt(2, permission);
		
		psmt.executeUpdate();
		closeConnection(psmt);
		return true;
	}
	
	private void closeConnection(Statement st) throws SQLException {
		st.close();
//		conn.close();
	}
	
	private List<AccountDTO> wrapDataToAccountDTO(ResultSet rs) throws SQLException{
		
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		
		while(rs.next()) {
			list.add(new AccountDTO(rs.getString("id"), 
					rs.getString("password"), 
					rs.getString("name"),  
					rs.getString("phoneNumber"), 
					rs.getDate("birth"), 
					rs.getString("address")
					)
			);
		}
		
		return list;
		
	}
	
	@Override
	public AccountDTO getAccountbyID(Connection conn, String ID) throws SQLException {
		
		AccountDTO dto = null;
		
	    PreparedStatement psmt = null;
	    String query = "select * from accounts where id = ?";
        
       dto = getAccount(conn, psmt, query, ID);
		
		if(Objects.isNull(dto))
			return null;
		else
			return dto;
	}
	
	@Override
	public boolean registAccount(Connection conn, AccountDTO dto) throws SQLException, ParseException {
		
	    PreparedStatement psmt = null;
	    String query = "INSERT INTO accounts (id,password,name,phoneNumber,birth,address) VALUES (?,?,?,?,?,?)";
	    
	    

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birth = sdf.format(dto.getBirth());
	    
		return insertAccount(conn, psmt, query, dto.getId(), dto.getPassword(),
									dto.getName(), dto.getPhoneNumber()
									, birth, dto.getAddress());
		
		
		
	}
	
	@Override
	public boolean registAccountPermission(Connection conn, String ID, Integer permission) throws SQLException {
		
		PreparedStatement psmt = null;
	    String query = "INSERT INTO account_permission (id,permission) VALUES (?,?)";
	   
	    if(!Objects.isNull(query))
	    	throw new SQLException();
	    
		return insertPermission(conn, psmt, query, ID, permission);
		
		
	}
	
	

}
