package org.jsp.MailSenderApi.controller;

import org.jsp.MailSenderApi.dto.EmailConfiguration;
import org.jsp.MailSenderApi.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000/")
public class SendEmailController {
	@Autowired
	private SendEmailService emailService;
	@Autowired
	private EmailConfiguration configuration;
	@PostMapping("/sendmail")
	public String sendEmail(String emailId) {
		configuration.setEmail(emailId);
		configuration.setSubject("Testing java mail sender.");
		configuration.setText("Program generated message to Test.");
		return emailService.sendEmail(configuration);
	}
}
