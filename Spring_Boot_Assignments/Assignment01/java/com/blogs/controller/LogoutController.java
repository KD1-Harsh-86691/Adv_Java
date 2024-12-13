package com.blogs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
//	@PostMapping("/out")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/logout.jsp";
	}
}
