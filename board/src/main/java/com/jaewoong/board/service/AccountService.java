package com.jaewoong.board.service;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jaewoong.board.DAO.IAccountDAO;
import com.jaewoong.board.DTO.AccountDTO;

import VO.LoginVO;

@Service("LoginService")
public class AccountService implements IAccountService{
	
	@Autowired
	@Qualifier("LoginDAO")
	IAccountDAO dao;
	
	@Override
	public AccountDTO confirmLogin(LoginVO vo) {
		
		AccountDTO dto = dao.getAccountbyID(vo.getId());
		
		if(Objects.isNull(dto) || !dto.getPassword().equals(vo.getPassword()))
			return null;
		
		
		return dto;
	}
	
}
