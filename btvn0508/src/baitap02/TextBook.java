package baitap02;

public class TextBook extends Book {
	private String subject;

	public TextBook() {
		// TODO Auto-generated constructor stub
	}

	public TextBook(String subject) {
		super();
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
		System.out.printf("|%-12s|%-12s|%-12s|%-12s|", super.getTitle(), super.getAuthor(), super.getIsbn(),
				this.subject);
		System.out.println("");
	}

	@Override
	public void inputData() {
		// TODO Auto-generated method stub
		super.inputData();
		System.out.println("Input subject");
		this.subject = sc.nextLine();

	}

}
