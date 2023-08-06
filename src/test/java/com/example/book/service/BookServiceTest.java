package com.example.book.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.Test;
import com.example.book.model.Book;
import com.example.book.web.rest.errors.BookBadRequestException;

public class BookServiceTest {

	BookService service = new BookService();

	@Test
	public void save() {
		Book book = new Book(1, "1", "1", "1");
		Book result = service.save(book);
		assertEquals(result, book);
	}

	@Test
	public void saveFailed() {
		Book book = new Book(1, null, "1", "1");
		assertThrows(BookBadRequestException.class, () -> {
			service.save(book);
		});
	}

}
