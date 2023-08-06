package com.example.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book.model.Book;
import com.example.book.util.Util;
import com.example.book.web.rest.errors.BookBadRequestException;
import com.example.book.web.rest.errors.ErrorConstants;
import com.example.book.web.rest.errors.ErrorVM;
import com.example.book.web.rest.errors.ItemNotFoundException;

@Service
public class BookService {

	public List<Book> getAll() {
		return Util.getBooks();
	}

	public Book save(final Book book) {
		if (book.getTitle() == null) {
			throw new BookBadRequestException(new ErrorVM(ErrorConstants.BAD_REQUEST, ErrorConstants.TITLE_NULL, ErrorConstants.CODE_BAD_REQUEST));
		}
		Util.getBooks().add(book);
		return book;
	}

	public boolean delete(final long id) {
		List<Book> list = Util.getBooks();
		boolean result = list.removeIf(book -> book.getId() == id);
		if (!result) {
			throw new ItemNotFoundException(new ErrorVM(ErrorConstants.DATA_NOT_FOUND, ErrorConstants.ID_NOT_FOUND, ErrorConstants.CODE_NOT_FOUND));
		}
		return result;
	}

	public Book edit(final Book book) {
		if (book.getTitle() == null) {
			throw new BookBadRequestException(new ErrorVM(ErrorConstants.BAD_REQUEST, ErrorConstants.TITLE_NULL, ErrorConstants.CODE_BAD_REQUEST));
		}
		if (delete(book.getId())) {
			Util.getBooks().add(book);
		}
		return book;
	}
}
