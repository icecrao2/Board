package com.jaewoong.board.Controller;


import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jaewoong.board.DTO.AccountDTO;
import com.jaewoong.board.service.IAccountService;

import VO.LoginVO;

/**
 * Handles requests for the application home page.
 */
@RestController
public class AccountRestController {
	
	@Autowired
	@Qualifier("LoginService")
	IAccountService service;
	

	@RequestMapping(value = "Login", method = RequestMethod.POST)
	public AccountDTO confirmLogin(LoginVO loginVo, HttpServletRequest request) {
		
		AccountDTO dto = service.confirmLogin(loginVo);
		
		HttpSession session = request.getSession();
		
		if(!Objects.isNull(dto)) {
			session.setAttribute("account", dto);
			return (AccountDTO)session.getAttribute("account");
		}else {
			return null;
		}
	}
	
	
}
