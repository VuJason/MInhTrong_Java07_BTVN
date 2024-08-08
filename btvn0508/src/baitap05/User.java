package baitap05;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String user_id;
	private String name;
	private List<Book> borrowed_books;

	public User() {
		this.borrowed_books = new ArrayList<Book>();
	}

	public User(String user_id, String name, List<Book> borrowed_books) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.borrowed_books = borrowed_books != null ? borrowed_books : new ArrayList<>();
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBorrowed_books() {
		return borrowed_books;
	}

	public void setBorrowed_books(List<Book> borrowed_books) {
		this.borrowed_books = borrowed_books;
	}

	// Hàm borrow nhạn vào quyển sách cần mượn
	public void borrow(Book book) {
		borrowed_books.add(book);
	}

	public void returned_book(Book book) {
		borrowed_books.remove(book);

	}

	public void displayInfo() {
		StringBuilder borrowedBooksInfo = new StringBuilder();
		for (Book book : borrowed_books) {
			borrowedBooksInfo.append(book.getTitle()).append(", ");
		}
		String borrowedBooksString = borrowed_books.isEmpty() ? "None"
				: borrowedBooksInfo.substring(0, borrowedBooksInfo.length() - 2);
		System.out.printf("|%6s|%-12s|%-12s|", this.user_id, this.name, borrowedBooksString);
		System.out.println("");
	}

	public String getBorrowedBook() {
		for (Book book : borrowed_books) {
			return book.getTitle();
		}
		return null;
	}

}
