package com.jaewoong.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaewoong.board.DAO.IAccountDAO;
import com.jaewoong.board.DTO.AccountDTO;
import com.jaewoong.board.DTO.RegistAccountDTO;

import VO.LoginVO;

@Service("LoginService")
public class AccountService implements IAccountService{
	
	@Autowired
	@Qualifier("LoginDAO")
	IAccountDAO dao;
	
	@Autowired
	BasicDataSource dataSource;

	Connection conn = null;
	
	@Override
	public AccountDTO confirmLogin(LoginVO vo) {
		
		
		AccountDTO dto;
		
		try {
			conn = dataSource.getConnection();
			dto = dao.getAccountbyID(conn, vo.getId());
			
			conn.close();
			
			if(Objects.isNull(dto) || !dto.getPassword().equals(vo.getPassword()))
				return null;
			return dto;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	@Override
	public boolean registAccount(RegistAccountDTO Rdto) {
		
		AccountDTO dto = Rdto.Swappping();
	
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			
			dao.registAccount(conn, dto);
			dao.registAccountPermission(conn, dto.getId(), 1);
			
			conn.commit();
			conn.setAutoCommit(true);
			
			conn.close();
		} catch (Exception e) {
			try{conn.rollback();}catch(SQLException sqle){}
		}
		
		return false;
	}
	
}
