package baitap05;

public class Book {
	private String title;
	private String author;
	private String isbn;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void displayInfo() {
		System.out.printf("|%-12s|%-12s|%8s|", this.title, this.author, this.isbn);
		System.out.println("");
	}

}
