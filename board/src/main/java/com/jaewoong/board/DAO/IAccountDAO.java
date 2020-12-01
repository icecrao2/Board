package com.jaewoong.board.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import com.jaewoong.board.DTO.AccountDTO;


public interface IAccountDAO {

	
	public AccountDTO getAccountbyID(Connection conn, String ID) throws SQLException;
	public boolean registAccount(Connection conn, AccountDTO dto) throws SQLException, ParseException;
	public boolean registAccountPermission(Connection conn, String ID, Integer permission) throws SQLException;
}
