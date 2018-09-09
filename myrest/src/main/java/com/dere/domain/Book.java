package com.dere.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@XmlElement(name="title")
	private String title;
	  
	private Float price;

	public Book() {
		
	}
	
	public Book( String title, Float price) {
		super();
	
		this.title = title;

		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	
	
}
