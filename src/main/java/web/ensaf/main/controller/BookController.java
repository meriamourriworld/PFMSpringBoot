package web.ensaf.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.ensaf.main.model.Book;
import web.ensaf.main.model.MyBooks;
import web.ensaf.main.service.BookServiceImpl;
import web.ensaf.main.service.MyBooksServiceImpl;

@Controller
public class BookController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	@Autowired
	private MyBooksServiceImpl myBooksService;
	
	
	//GET Available BOOKS
	@GetMapping("/user/available-books")
	public String getAllBooks(Model model)
	{
	    List<Book> listBooks = bookService.findAllBooks();
		model.addAttribute("books", listBooks);
		return "book/available-books";
	}
	
	//Save a BOOK
	@GetMapping("/user/add-book")
	public String addBook()
	{
		return "book/add-book";
	}

	@PostMapping("/user/available-books")
	public String registerBook(@RequestParam("author") String author, @RequestParam("name") String name, @RequestParam("price") int price)
	{
		System.out.println("req params "+author);
		bookService.saveBook(new Book(author, name, price));
		return "redirect:/available-books";
	}
	
	//CRUD ON AVAILABLE BOOKS
	//Book a book
	@GetMapping("/user/reservations/addMyBook/{id}")
	public String addBookReservation(@PathVariable("id") int id)
	{
		Book foundBook = bookService.findById(id);
		myBooksService.addMyBook(new MyBooks(foundBook.getId(), foundBook.getName(), foundBook.getAuthor(), foundBook.getPrice()));
		return "redirect:/my-books";
	}
	
	//Delete a Book
	@GetMapping("/user/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id)
	{
		bookService.deleteById(id);
		return "redirect:/available-books";
	}
	
	//Edit a Book
	@GetMapping("/user/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model)
	{
		Book foundBook = bookService.findById(id);
		model.addAttribute("book", foundBook);
		return "book/edit-book";
	}
}
