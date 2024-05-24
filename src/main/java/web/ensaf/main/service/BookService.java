package web.ensaf.main.service;

import java.util.List;

import web.ensaf.main.model.Book;

public interface BookService {
	
	public List<Book> findAllBooks();
	public Book findById(int id);
	public void saveBook(Book book);
	public void deleteById(int id);
	void updateBook(Book book);
}
