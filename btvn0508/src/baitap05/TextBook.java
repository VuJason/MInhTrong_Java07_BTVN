package baitap05;

public class TextBook extends Book {
	private String subject;

	public TextBook() {
		// TODO Auto-generated constructor stub
	}

	public TextBook(String title, String author, String isbn,String subject) {
		super(title, author, isbn);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		System.out.printf("|%-12s|%-12s|%8s|%-12s|", super.getTitle(), super.getAuthor(), super.getIsbn(),
				this.subject);
		System.out.println("");
	}

}
