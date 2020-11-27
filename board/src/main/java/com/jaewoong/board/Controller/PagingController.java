package com.jaewoong.board.Controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaewoong.board.HomeController;

@Controller
public class PagingController {


	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "Main", method = RequestMethod.GET)
	public String goMainPage() {
		return "Main";
	}
	
	@RequestMapping(value = "AccountRegist", method = RequestMethod.GET)
	public String goAccountRegistPage() {
		return "AccountRegist";
	}
	
}