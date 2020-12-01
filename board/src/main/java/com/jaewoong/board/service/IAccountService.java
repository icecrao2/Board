package com.jaewoong.board.service;

import java.text.ParseException;

import com.jaewoong.board.DTO.AccountDTO;
import com.jaewoong.board.DTO.RegistAccountDTO;

import VO.LoginVO;

public interface IAccountService {

	public AccountDTO confirmLogin(LoginVO vo);	
	public boolean registAccount(RegistAccountDTO dto) throws ParseException;
	
}
