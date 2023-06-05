package com.cts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.dto.User;
import com.cts.exception.UserNotFoundException;
import com.cts.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("userName")
public class LoginControler {
	private final Logger LOGGER =LoggerFactory.getLogger(LoginControler.class);
 
	@Autowired
	private UserService service;

	
	private void addUserInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userName", u.getUserName());
        
    }
	@GetMapping("/loginPage")
	public String showLoginPage(Model model) {
		LOGGER.info("Start");
		model.addAttribute("login",new User());
		LOGGER.info("End");
		return "login";
	}

	@PostMapping("/welcome")
	public String login(@ModelAttribute("login") @Valid User user, BindingResult result, HttpSession session) throws UserNotFoundException {
		
		LOGGER.info("Start");
		if(result.hasErrors()) {
			return "login";
		}
			
		User userFromDb = service.login(user);
			LOGGER.debug("Check User:"+userFromDb);
			addUserInSession(userFromDb, session);
			LOGGER.info("End");
			return "welcome";
	}
	
	@RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginPage?act=lo";
    }
	
	@GetMapping("/welcome")
	public String getWelcomePage() {
		return "/welcome";
	}

}
