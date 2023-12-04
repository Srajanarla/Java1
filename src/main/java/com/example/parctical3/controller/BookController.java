package com.example.parctical3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parctical3.dto.BookDTO;
import com.example.parctical3.entity.UserInfo;
import com.example.parctical3.service.BookService;
import com.example.parctical3.service.JwtService;
import com.example.parctical3.dto.AuthRequest;
import config.SecurityConfig;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
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
//    @PostMapping("/new")
//  public String addNewUser(@RequestBody UserInfo userInfo) {
//      return service.addUser(userInfo);
//  }
    
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
 }
}
