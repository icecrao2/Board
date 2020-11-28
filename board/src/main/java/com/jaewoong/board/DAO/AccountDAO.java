package com.jaewoong.board.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jaewoong.board.DTO.AccountDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import VO.LoginVO;

@Component(value = "LoginDAO")
public class AccountDAO implements IAccountDAO{

	@Autowired
	BasicDataSource dataSource;

	private AccountDTO getAccount(Connection conn, PreparedStatement psmt, String query, String... args){
	

        ResultSet rs = null;
		
        List<AccountDTO> dto = null;
        
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(query);
			
			for(int a = 0 ; a < args.length ; a++)
				psmt.setString(a+1, args[0]);
			
			rs = psmt.executeQuery();
		
			dto = wrapDataToAccountDTO(rs);
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			closeConnection(conn, psmt);
		} 
		
		if(dto.size() == 0)
			return null;
		
		return dto.get(0);
	}
	
	private void closeConnection(Connection conn, Statement st) {
		
		try {
	            if(st != null) st.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        try {
	            if(conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }     
	}
	
	private List<AccountDTO> wrapDataToAccountDTO(ResultSet rs) throws SQLException{
		
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		
		while(rs.next()) {
			list.add(new AccountDTO(rs.getString("id"), 
					rs.getString("password"), 
					rs.getString("name"), 
					rs.getInt("permission"), 
					rs.getString("phoneNumber"), 
					rs.getDate("birth"), 
					rs.getString("address")
					)
			);
		}
		
		return list;
		
	}
	
	@Override
	public AccountDTO getAccountbyID(String ID) {
		
		AccountDTO dto = null;
		
		Connection conn = null;
	    PreparedStatement psmt = null;
	    String query = "select * from accounts where id = ?";
        
       dto = getAccount(conn, psmt, query, ID);
		
		if(Objects.isNull(dto))
			return null;
		else
			return dto;
	}
	
	

}
