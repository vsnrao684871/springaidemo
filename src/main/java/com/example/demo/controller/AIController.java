package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AudioService;
import com.example.demo.service.ChatService;

@RestController
public class AIController {
	
	@Autowired
	ChatService service;
	
	@Autowired
	public AudioService audioService;
	
	@GetMapping("/ask-ai")
	public String askAI(@RequestParam String prompt) {
		
		return service.askAI0(prompt);
	}
	
	@GetMapping("/generate-audio")
	public String generateImage(@RequestParam String prompt) {
		return audioService.convertTextToSpeech(prompt);
	}


}
