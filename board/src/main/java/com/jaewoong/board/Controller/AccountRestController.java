package com.jaewoong.board.Controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/accountform", method = RequestMethod.POST)
	public AccountDTO AccountRegist(@RequestParam String id,
									@RequestParam String password,
									@RequestParam String name,
									@RequestParam String phoneNumber,
									@RequestParam String birth,
									@RequestParam String zipno,
									@RequestParam String roadAddrPart1,
									@RequestParam String addrDetail,
									@RequestParam String roadAddrPart2
									) {

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date D_birth;
		try {
			D_birth = transFormat.parse(birth);
			AccountDTO dto = new AccountDTO(id, password, name, 1, phoneNumber, D_birth, zipno, roadAddrPart1, addrDetail, roadAddrPart2);

			return dto;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//회원등록 처리 해줘야함
		
		return null;
	}
	
	
}
