package com.raken.takehome.model;

import java.util.ArrayList;

public class EmailBody {
	
	  private From FromObject;
	  private String subject;
	  private ArrayList<Personalization> personalizations = new ArrayList<Personalization>();
	  private ArrayList<Content> content = new ArrayList<Content>();


	 // Getter Methods 

	  public From getFrom() {
	    return FromObject;
	  }

	  public String getSubject() {
	    return subject;
	  }

	 // Setter Methods 

	  public void setFrom( From fromObject ) {
	    this.FromObject = fromObject;
	  }

	  public void setSubject( String subject ) {
	    this.subject = subject;
	  }

	public ArrayList<Personalization> getPersonalizations() {
		return personalizations;
	}

	public void setPersonalizations(ArrayList<Personalization> personalizations) {
		this.personalizations = personalizations;
	}

	public ArrayList<Content> getContent() {
		return content;
	}

	public void setContent(ArrayList<Content> content) {
		this.content = content;
	}
}
