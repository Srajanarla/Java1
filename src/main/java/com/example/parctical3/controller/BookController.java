package com.example.parctical3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parctical3.dto.BookDTO;
import com.example.parctical3.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
    @PostMapping("/addBook")
    public String addBook(@RequestBody BookDTO bookDTO ){
      String received=bookService.addBook(bookDTO);
    		  return received;
    }
    @GetMapping("/allbook")
    public List<BookDTO> getAllBook()
    {
    	List<BookDTO> received=bookService.getAllBook();
    	return received;
    }
    @PutMapping("/editBook/{bookId}/{bookName}")
    public String editBook(@PathVariable int bookId,String bookName )
    {
		String received=bookService.editBook(bookId,bookName);
		return received;
    }
    @DeleteMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable int bookId)
    {
    	String received=bookService.removeBook(bookId);
    	return received;
    }
}
