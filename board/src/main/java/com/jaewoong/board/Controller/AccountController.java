package com.jaewoong.board.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaewoong.board.DTO.AccountDTO;

@Controller
public class AccountController {
	
	@RequestMapping(value="MyAccountInfo", method = RequestMethod.GET)
	public String MyAccountInfo(HttpServletRequest request, Model model)
	{
		HttpSession session = request.getSession();
		
		model.addAttribute("account", (AccountDTO)session.getAttribute("account"));
		
		return "MyAccountInfo";
	}

}
