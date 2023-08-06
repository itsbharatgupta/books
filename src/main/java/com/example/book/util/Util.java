package com.example.book.util;

import java.util.ArrayList;
import java.util.List;

import com.example.book.model.Book;

public class Util {

	private static List<Book> books = new ArrayList<>();
	
	static {
		books.add(new Book(1,"New Maths Formula", "Ajay verma", "12HTYR-123SHFSH"));
		books.add(new Book(2,"Hindi Grammer", "Ramesh verma", "OKAKOA-12HTYR"));
		books.add(new Book(3,"English Litreture", "Sumit verma", "GRRGRG-9863JSDG"));
		books.add(new Book(4,"Computer Information", "Mangla verma", "9865HKHK-123SHFSH"));
		books.add(new Book(5,"New Science", "Ajay verma", "08979869-123SHFSH"));
	}

	public static List<Book> getBooks() {
		return books;
	}

}
