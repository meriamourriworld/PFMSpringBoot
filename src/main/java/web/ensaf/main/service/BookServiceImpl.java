package web.ensaf.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.ensaf.main.model.Book;
import web.ensaf.main.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository brepo;

	@Override
	public List<Book> findAllBooks() {
		return brepo.findAll();
	}

	@Override
	public Book findById(int id) {
		return brepo.findById(id).get();
	}

	@Override
	public void saveBook(Book book) {
		brepo.save(book);
	}

	@Override
	public void deleteById(int id) {
		brepo.deleteById(id);
	}

	@Override
	public void updateBook(Book book) {
		brepo.save(book);
	}

}
