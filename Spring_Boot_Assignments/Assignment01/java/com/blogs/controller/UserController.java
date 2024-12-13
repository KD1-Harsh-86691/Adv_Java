package com.blogs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;
import com.blogs.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	// depcy
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in constructor " + getClass());
	}

	/*
	 * URL - http://host:port/ctx/users/signin method - POST resp - redirect view
	 * name --> home page
	 */
	@PostMapping("/signin")
	/*
	 * @RequestParam - method arg level annotation, to bind to method arg (reco -
	 * match the names)
	 * 
	 * @RequestParam String email Sc = String
	 * email=request.getParameter("email")....
	 * 
	 */
	public String singInUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
		System.out.println("in sign in " + email + "" + password);
//		invoked service layer method
		try {
			User user = userService.getUser(email, password);
			// => valid login,save user detail under session scope continue to authorization
			session.setAttribute("user_details", user);
			if (user.getRole() == UserRole.ADMIN)
				return "redirect:/admin/home";
			if (user.getRole() == UserRole.BLOGGER)
				return "redirect:/blogger/home";

		} catch (RuntimeException e) {
			System.out.println("err in controller" + e);
			// in case of invalid login -> redorect a client to login page, highlighted with
			// error message
			// add a error message under session scope
			session.setAttribute("mesg", "please retry , invalid email or password!");
			return "redirect:/";
			// SC --> WC -> response.sendRedirect("/");

		}
		return "";
	}

}
