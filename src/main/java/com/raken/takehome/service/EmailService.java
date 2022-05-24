/**
 * 
 */
package com.raken.takehome.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.raken.takehome.model.Email;
import com.raken.takehome.model.EmailBody;
import com.raken.takehome.model.From;
import com.raken.takehome.util.EmailUtil;

import reactor.core.publisher.Mono;


/**
 * @author jagmohan swain
 *
 */

@Service
public class EmailService {

	
	private final WebClient client;
	
	@Autowired
	private Environment env;

	public EmailService(WebClient.Builder builder) {
	    this.client = builder.baseUrl("https://api.sendgrid.com/v3/").build();
	}
	
	// Use webclient for a non blocking asynchronous invocation of sendgrid rest api
	public Mono<String> sendEmail(Email email) {
			EmailBody emailBody = new EmailBody();
			EmailUtil emailUtil = new EmailUtil();
			emailUtil.populateEmailBody(emailBody, email);
			
			return this.client.post()
				.uri("mail/send")
				.header(HttpHeaders.AUTHORIZATION, env.getProperty("app.sendgridkey"))
				.bodyValue(emailBody)
			    .retrieve()
			    .bodyToMono(String.class);
	}
	
	// Below sendgrid java reference client code example is commented out as it is a blocking call
	
	/* 
	public void sendGridEmail() throws IOException {
		com.sendgrid.Email from = new com.sendgrid.Email("test@example.com");
	    String subject = "Sending with SendGrid is Fun";
	    com.sendgrid.Email to = new com.sendgrid.Email("test@example.com");
	    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
	  } */
	

}
