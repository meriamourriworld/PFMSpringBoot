package web.ensaf.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.ensaf.main.model.Book;
import web.ensaf.main.service.BookServiceImpl;

@Controller
public class BookController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	
	@GetMapping("/available-books")
	public String getAllBooks(Model model)
	{
	    List<Book> listBooks = bookService.findAllBooks();
		model.addAttribute("books", listBooks);
		return "available-books";
	}
	
	@GetMapping("/add-book")
	public String addBook()
	{
		return "add-book";
	}

	@PostMapping("/available-books")
	public String registerBook(@RequestParam("author") String author, @RequestParam("name") String name, @RequestParam("price") int price)
	{
		System.out.println("req params "+author);
		bookService.saveBook(new Book(author, name, price));
		return "redirect:/available-books";
	}
}
