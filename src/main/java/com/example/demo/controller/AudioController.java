package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.AudioService;

public class AudioController {
	
	@Autowired
	public AudioService audioService;
	
	
	@GetMapping("/generate-audio")
	public String generateImage(@RequestParam String prompt) {
		return audioService.convertTextToSpeech(prompt);
	}

}
