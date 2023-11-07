package com.example.parctical3.service;

import java.util.List;

import com.example.parctical3.dto.BookDTO;

public interface BookService {
	
	public String addBook(BookDTO bookDTO);

	public List<BookDTO> getAllBook();

	public String editBook(int bookId,String bookName);

	public String removeBook(int bookId);


}
