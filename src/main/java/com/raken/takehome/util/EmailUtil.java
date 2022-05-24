package com.raken.takehome.util;

import java.util.ArrayList;

import com.raken.takehome.model.Content;
import com.raken.takehome.model.Email;
import com.raken.takehome.model.EmailBody;
import com.raken.takehome.model.EmailObject;
import com.raken.takehome.model.From;
import com.raken.takehome.model.Personalization;

public class EmailUtil {
	public void populateEmailBody(EmailBody emailBody, Email email) {
		
		From from = new From();
		from.setEmail("purijagmohan@gmail.com"); // Adding a default since none is mentioned in task
		emailBody.setFrom(from);
		
		emailBody.setSubject(email.getSubject()); // add subject
		
		EmailObject to = new EmailObject();
		to.setEmail(email.getTo());  // add to
		
		EmailObject cc = new EmailObject();
		to.setEmail(email.getCC());  // add cc
		
		ArrayList<EmailObject> tolist = new ArrayList<EmailObject>();
		ArrayList<EmailObject> cclist = new ArrayList<EmailObject>();
		
		tolist.add(to);
		cclist.add(cc);
		
		Personalization personalization = new Personalization();
		personalization.setTo(tolist);
		personalization.setCc(cclist);
		ArrayList<Personalization> personalizations = new ArrayList<Personalization>();
		personalizations.add(personalization);
		emailBody.setPersonalizations(personalizations);
		
		ArrayList<Content> contents = new ArrayList<Content>();
		Content content = new Content();
		content.setType("text/plain");
		content.setValue(email.getBody());
		emailBody.setContent(contents);
		
	}

}
