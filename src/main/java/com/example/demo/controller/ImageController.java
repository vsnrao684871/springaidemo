package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ImageService;

@RestController
public class ImageController {

	@Autowired
	ImageService imageService;

	@GetMapping("/generate-image")
	public String generateImage(@RequestParam String prompt) {
		return imageService.generateImage(prompt);
	}

}
