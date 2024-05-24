package web.ensaf.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.ensaf.main.model.MyBooks;
import web.ensaf.main.repository.MyBooksRepository;

@Service
public class MyBooksServiceImpl implements MyBooksService{
	@Autowired
	MyBooksRepository myBooksRepo;

	@Override
	public List<MyBooks> findMyReservations() {
		return myBooksRepo.findAll();
	}

	@Override
	public void deleteReservation(int id) {
		myBooksRepo.deleteById(id);
	}

	@Override
	public void addMyBook(MyBooks book) {
		myBooksRepo.save(book);
	}

}
