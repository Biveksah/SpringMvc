package com.Broadway.SpringMvc.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Broadway.SpringMvc.Model.User;
import com.Broadway.SpringMvc.Repository.UserRepository;
import com.Broadway.SpringMvc.Utils.VerifyRecaptcha;

@Controller
public class LoginSignUpController {
	
	 private static final Logger logger=LoggerFactory.getLogger(LoginSignUpController.class);
	@Autowired
	private UserRepository lsRepo;

	@GetMapping("/")
	private String showloginSignUp() {
		logger.info("=======login sucess==========");
		return "LoginSign";
	}

	@GetMapping("/singUp")
	private String showSignUp() {
		logger.info("=======Signup sucess==========");
		return "LoginSign";
	}

	@PostMapping("/login")
	private String doLogin(@ModelAttribute User u, Model model, HttpSession session) {
		// u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		User usr = lsRepo.findByusernameAndPassword(u.getUsername(), u.getPassword());
		if (usr != null) {
			
			session.setAttribute("validuser", usr);
			model.addAttribute("uname",u.getUsername());
			return "Home";
		}
		return "LoginSign";
	}

	@PostMapping("/signUp")
	private String doSignUp(@ModelAttribute User u, Model model,@RequestParam("g-recaptcha-response") String gcode) throws IOException {
		if(VerifyRecaptcha.verify(gcode))
		{
			model.addAttribute("");
			lsRepo.save(u);
		}
		else
		{
			model.addAttribute("msg","you are not human");
			
		}

		
		return "LoginSign";
	}
	@GetMapping("/signUp")
	private String logout(HttpSession session)
	{
		session.invalidate();
		return"LoginSign";
	}
}
