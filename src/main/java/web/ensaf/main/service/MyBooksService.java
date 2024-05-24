package web.ensaf.main.service;

import java.util.List;

import web.ensaf.main.model.MyBooks;

public interface MyBooksService {

	public List<MyBooks> findMyReservations();
	public void addMyBook(MyBooks book);
	public void deleteReservation(int id);
}
