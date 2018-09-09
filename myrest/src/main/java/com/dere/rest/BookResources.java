package com.dere.rest;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dere.domain.Book;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;



@Path("books")
public class BookResources {

	public BookResources() {
		
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String book() {
		JsonObject jo = new JsonObject();
		jo.addProperty("Hello", "World");
		JsonArray ja = new JsonArray();
		ja.add(jo);
		return ja.toString();
		
	}
	
	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book books(@PathParam("name") String name) {

		return new Book(name, 12.3f);
	}
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> books() {
		
		List<Book> books = new ArrayList<>();
		books.add(new Book("Shroud", 12.3f));
		books.add(new Book("The Catcher in the rye", 2.5f));
		books.add(new Book("The Little Prince", 5f));
		books.add(new Book("Ake: Years of childhood", 12.3f));
		
		return books;
	}
	
}
