package baitap02;

import java.util.Scanner;

public abstract class Book {
	private String title;
	private String author;
	private String isbn;
	protected Scanner sc = new Scanner(System.in);
	
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
		System.out.printf("|%-12s|%-12s|%-12s|", this.title, this.author, this.isbn);
		System.out.println("");
	}
	
	public void inputData() {
		System.out.println("Input title: ");
		this.title = sc.nextLine();
		System.out.println("Input author: ");
		this.author = sc.nextLine();
		System.out.println("Input isbn: ");
		this.isbn = sc.nextLine();
		
	}
	
}
