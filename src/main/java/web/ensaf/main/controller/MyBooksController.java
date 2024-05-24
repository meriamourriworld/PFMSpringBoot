package web.ensaf.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import web.ensaf.main.service.MyBooksServiceImpl;

@Controller
public class MyBooksController {
	@Autowired
	MyBooksServiceImpl myBooksService;
	
	@GetMapping("/my-books")
	public String getMyBooks(Model model)
	{
		model.addAttribute("myBooks", myBooksService.findMyReservations());
		return "book/my-books";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deleteMyBooks(@PathVariable("id") int id)
	{
		myBooksService.deleteReservation(id);
		return "redirect:/my-books";
	}
}
