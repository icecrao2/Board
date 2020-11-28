package com.jaewoong.board.DAO;

import com.jaewoong.board.DTO.AccountDTO;

import VO.LoginVO;

public interface IAccountDAO {

	
	public AccountDTO getAccountbyID(String ID);
}
