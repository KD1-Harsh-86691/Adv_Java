package com.blogs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogs.service.BlogPostService;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
	@Autowired
	private BlogPostService postService;

	public BloggerController() {
		System.out.println("in ctor"+getClass());
	}
	
	@GetMapping("/home")
	public String renderPostDisplayPage(Model map) {
		map.addAttribute("post_list", postService.getAllBlogPosts());
		return "/blogger/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/logout";
	}
	
}
