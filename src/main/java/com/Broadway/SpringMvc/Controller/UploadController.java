package com.Broadway.SpringMvc.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("/upload")
	private String showUploadFor() {
		return "Upload";
	}

	@PostMapping("/upload")
	public String saveImage(@RequestParam("image") MultipartFile img, Model model) {
		// String imgpath=img.getInputStream(),Path.of("src/main/resources/static/Images/"+img.getOriginalFilename());
		if (!img.isEmpty()) {
			try {
				Files.copy(img.getInputStream(),
						Path.of("src/main/resources/static/Images/" + img.getOriginalFilename()),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		return "Upload";
	}
}
