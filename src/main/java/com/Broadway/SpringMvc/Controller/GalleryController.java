package com.Broadway.SpringMvc.Controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
	@GetMapping("/gallery")
	public String showGalleryForm(Model model,HttpSession session) {
		if(session.getAttribute("validuser")==null)
		{
			return"LoginSign";
		}
		String[] imageNames = new File("src/main/resources/static/Images").list();
		model.addAttribute("imglist", imageNames);

		return "Gallery";
	}

}
