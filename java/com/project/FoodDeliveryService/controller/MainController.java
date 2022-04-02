package com.project.FoodDeliveryService.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.repository.UserRepository;

@Controller
//@RestController
@CrossOrigin()
public class MainController {

	@Autowired
	UserRepository userRepo;

	@GetMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
	    public String getEmployees() {
	        return "home.jsp";
	    }
	

	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	@GetMapping("/Register")
	public String register() {
		return "register.jsp";
	}

//	@PostMapping("/signup")
//	public ResponseEntity<String>signup(@RequestBody JwtRequest jwtRequest) {
//		
//		return ResponseEntity.status();
//		
//	}
//
//	@GetMapping("/signupuser")
//	public ModelAndView signupuser(UserData user) {
//
//		ModelAndView mvAndView = new ModelAndView();
//		String message = "";
//		if (userRepo.existsByUsername(user.getUsername())) {
//			mvAndView.addObject("message", "Already registered please login here");
//			mvAndView.setViewName("error.jsp");
//		} else {
//			userRepo.save(user);
//			mvAndView.setViewName("registerstatus.jsp");
//		}
//		return mvAndView;
//	}
//
//
//	@GetMapping("/loginuser")
//	public ModelAndView loginuser(UserData currentuser) {
//
//		ModelAndView modelAndView = new ModelAndView();
//		String message = "";
//		UserData user = userRepo.findByUsername(currentuser.getUsername());
//		if (user == null) {
//			modelAndView.addObject("message", "Does not have an account Please Register");
//			modelAndView.setViewName("error.jsp");
//			return modelAndView;
//		} else if (user.getPassword().equals(currentuser.getPassword())) {
//			modelAndView.setViewName("Welcome.jsp");
//			return modelAndView;
//
//		} else {
//			modelAndView.addObject("message", "Password Incorrect Login Again");
//			modelAndView.setViewName("error.jsp");
//			return modelAndView;
//		}
//
//	}
}


