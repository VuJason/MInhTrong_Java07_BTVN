package baitap02;

public class BookApplication {
	public static void main(String[] args) {
		TextBook txt1 = new TextBook();
		txt1.inputData();
		txt1.displayInfo();

		ReferenceBook ref = new ReferenceBook();
		ref.inputData();
		ref.displayInfo();

	}
}
