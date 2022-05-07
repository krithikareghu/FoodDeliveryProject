package project.Main.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.jsonwebtoken.impl.crypto.MacValidator;
import project.Main.Controller.Model.UserData;
import project.Main.Controller.Repository.UserRepository;
import javax.servlet.http.HttpServletRequest; 
@Controller
public class MainController {
	
@Autowired
UserRepository userRepo;
	@GetMapping("/Home")
	public String home() {
		return "home.jsp";
	}
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	@GetMapping("/Register")
	public String register() {
		//System.out.println(req.getParameter("email"));
		 //model.addAttribute("users", new UserData());
		return "register.jsp";
	}
	

	@RequestMapping(value="/signupuser",method=RequestMethod.POST)
//	public String signupuser (@RequestParam String firstname,@RequestParam String lastname,@RequestParam 
//	String email,@RequestParam String password)
	
	public String signupuser( @RequestBody UserData user)
	{
		
//		System.out.println(firstname);
//		System.out.println(lastname);
//		
//	  	UserData user=new UserData(email,password,firstname,lastname);
		System.out.println(user.getFirstname());
		//userRepo.save(user);
		return "registerstatus.jsp";
	}
	


//	@GetMapping("/signupuser")
//	public ModelAndView signupuser (UserData user)
//	{
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.addObject("obj",user);
//		modelAndView.setViewName("registerstatus.jsp");
//		userRepo.save(user);
//		return modelAndView;
//	}	
		
		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject(user);
		
//		return mv;
//	}
	
	
	@GetMapping("/loginuser")
	public String loginuser (UserData user)
	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject(user);
		//userRepo.save(user);
		return "Successfully Logged in";
//		return mv;
	}
	
}
//
//@GetMapping("/login")
//public String login() {
//	return "login";
//}
//
//@GetMapping("/")
//public String home() {
//	return "index";
//} 
