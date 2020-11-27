package com.jaewoong.board.service;

import com.jaewoong.board.DTO.AccountDTO;

import VO.LoginVO;

public interface ILoginService {

	public AccountDTO confirmLogin(LoginVO vo);	
	
}
