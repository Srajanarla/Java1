package com.example.parctical3.service;

import com.example.parctical3.dto.BookDTO;
import com.example.parctical3.entity.Book;
import com.example.parctical3.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service(value="BookService")
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;
	@Override
	public String addBook(BookDTO bookDTO) {
		// TODO Auto-generated method stub
		Book book=new Book();
		book.setBookId(bookDTO.getBookId());
		book.setBookName(bookDTO.getBookName());
		bookRepository.save(book);
		return "Book"+bookDTO.getBookId()+" created";
	}
	@Override
	public List<BookDTO> getAllBook() {
		// TODO Auto-generated method stub
		Iterable<Book> bookEntity=bookRepository.findAll();
		List<BookDTO> bookDTOs=new ArrayList<>();
		bookEntity.forEach(bookDTOa->{
			BookDTO bookDTO=new BookDTO();
			bookDTO.setBookId(bookDTOa.getBookId());
			bookDTO.setBookName(bookDTOa.getBookName());
			bookDTOs.add(bookDTO);
		});
		return bookDTOs;
	}
	@Override
//	public String editBook(int bookId, String bookName) {
//		// TODO Auto-generated method stub
//		Optional<Book> received=bookRepository.findById(bookId);
//		if(received.isPresent())
//		{
//			Book book=new Book();
//			book.setBookId(bookId);
//			book.setBookName(bookName);
//			bookRepository.delete(received.get());
//			bookRepository.save(book);
//		}
//		return "Book Id "+bookId+" edited Successfully";
//	}
	public String editBook(int bookId, String bookName) {
	    Optional<Book> optionalBook = bookRepository.findById(bookId);

	    if (optionalBook.isPresent()) {
	        Book existingBook = optionalBook.get();
	        existingBook.setBookName(bookName);
	        bookRepository.save(existingBook);
	        return "Book Id " + bookId + " edited Successfully";
	    } else {
	        return "Book with Id " + bookId + " not found. Unable to edit.";
	    }
	}

	@Override
	public String removeBook(int bookId) {
		// TODO Auto-generated method stub
		Optional<Book> received=bookRepository.findById(bookId);
		bookRepository.delete(received.get());
		return "Book "+bookId+" delted Successfully";
	}
	
	
}
