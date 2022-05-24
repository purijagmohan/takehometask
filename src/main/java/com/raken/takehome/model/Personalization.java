package com.raken.takehome.model;

import java.util.ArrayList;

public class Personalization {

	ArrayList < EmailObject > to = new ArrayList < EmailObject > ();
	ArrayList < EmailObject > cc = new ArrayList < EmailObject > ();

	public ArrayList<EmailObject> getTo() {
		return to;
	}
	public void setTo(ArrayList<EmailObject> to) {
		this.to = to;
	}
	public ArrayList<EmailObject> getCc() {
		return cc;
	}
	public void setCc(ArrayList<EmailObject> cc) {
		this.cc = cc;
	}

}