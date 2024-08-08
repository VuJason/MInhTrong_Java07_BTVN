package baitap05;

public class ReferenceBook extends Book {
	private String field;

	public ReferenceBook() {
		// TODO Auto-generated constructor stub
	}

	public ReferenceBook(String title, String author, String isbn, String field) {
		super(title, author, isbn);
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		System.out.printf("|%-12s|%-12s|%8s|%-12s|", super.getTitle(), super.getAuthor(), super.getIsbn(),
				this.field);
		System.out.println("");
	}

}
