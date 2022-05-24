package com.raken.takehome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.raken.takehome.model.Email;
import com.raken.takehome.service.EmailService;

import reactor.core.publisher.Mono;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/email")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<String> sendEmail(@RequestBody Email email){
		return emailService.sendEmail(email);
	}

}
