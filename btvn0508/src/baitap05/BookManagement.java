package baitap05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookManagement {
	private static Scanner sc = new Scanner(System.in);
	private static List<TextBook> textBookList = new ArrayList<>();
	private static List<ReferenceBook> refBookList = new ArrayList<>();
	private static List<User> userList = new ArrayList<>();
	private static final Pattern ISBN_PATTERN = Pattern.compile("^[0-9]{8}$");
	private static final Pattern USER_ID_PATTERN = Pattern.compile("^[0-9]{6}$");
	private static final Pattern NAME_PATTERN = Pattern.compile("^[\\p{L} ]{5,10}$");
	private static final Pattern SUBJECT_PATTERN = Pattern
			.compile("^|Math|Physic|Chemistry|Literature|English|Biology|History|Geography|Music|Art|&");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Create TextBook");
			System.out.println("2. Create Referece Book");
			System.out.println("3. Show All Books");
			System.out.println("4. User View");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				inputTextBook();
				break;
			case 2:
				inputReferenceBook();
				break;
			case 3:
				showAllBook();
				break;
			case 4:
				int userChoice = 0;
				do {
					System.out.println("User View:");
					System.out.println("1. Create User ");
					System.out.println("2. Show User Infomation");
					System.out.println("3. Borrow Book");
					System.out.println("4. Return Book");
					System.out.println("5. Back");
					System.out.println("Enter your choice:");
					userChoice = Integer.parseInt(sc.nextLine());
					if (userChoice == 1) {
						inputUser();
					} else if (userChoice == 2) {
						showUserInfo();
					} else if (userChoice == 3) {
						borrowBook();
					} else if (userChoice == 4) {
						returnedBook();
					}
				} while (userChoice != 5);
				break;

			default:
				break;
			}
		} while (choice != 5);
	}

	// Input Text Book
	public static void inputTextBook() {
		String title, author, isbn, subject;
		while (true) {
			System.out.println("Input book title: ");
			title = sc.nextLine();
			if (NAME_PATTERN.matcher(title).find()) {
				break;
			} else {
				System.err.println("Title must be 8 - 12 characters and related to subject!!");
			}
		}
		while (true) {
			System.out.println("Input book author: ");
			author = sc.nextLine();
			if (NAME_PATTERN.matcher(author).find()) {
				break;
			} else {
				System.err.println("Title must be 5 - 10 characters ");
			}
		}

		while (true) {
			System.out.println("Input isbn: ");
			isbn = sc.nextLine();
			if (ISBN_PATTERN.matcher(isbn).find()) {
				if (checkDuplicateISBN(isbn)) {
					System.err.println("This book already existed!!");
					return;
				} else {
					break;
				}
			} else {
				System.err.println("ISBN must be 8 digits ");
			}
		}

		while (true) {
			System.out.println("SUBJECTS:");
			System.out.println(
					"Math | Physic | Chemistry | Literature | English | Biology | History | Geography | Music | Art");
			System.out.println("Input book subject: ");
			subject = sc.nextLine();
			Matcher matcher = SUBJECT_PATTERN.matcher(subject);
			if (matcher.matches()) {
				break;
			} else {
				System.err.println("You need to input given subjects above!!!");
			}
		}

		TextBook textBook = new TextBook(title, author, isbn, subject);
		textBookList.add(textBook);
		System.out.println("Create successfully!!");
	}

	// Input Reference Book
	public static void inputReferenceBook() {
		String title, author, isbn, field;

		while (true) {
			System.out.println("Input book title: ");
			title = sc.nextLine();
			if (NAME_PATTERN.matcher(title).find()) {
				break;
			} else {
				System.err.println("Title must be 8 - 12 characters and related to subject!!");
			}
		}
		while (true) {
			System.out.println("Input book author: ");
			author = sc.nextLine();
			if (NAME_PATTERN.matcher(author).find()) {
				break;
			} else {
				System.err.println("Title must be 5 - 10 characters ");
			}
		}
		while (true) {
			System.out.println("Input isbn: ");
			isbn = sc.nextLine();
			if (ISBN_PATTERN.matcher(isbn).find()) {
				if (checkDuplicateISBN(isbn)) {
					System.err.println("This book already existed!!");
					return;
				} else {
					break;
				}
			} else {
				System.err.println("ISBN must be 8 digits ");
			}
		}
		System.out.println("Input book field: ");
		field = sc.nextLine();

		ReferenceBook refBook = new ReferenceBook(title, author, isbn, field);
		refBookList.add(refBook);
		System.out.println("Create successfully!!");

	}

	// Input User
	public static void inputUser() {
		String userID, name, borrowBook;
		while (true) {
			System.out.println("Input user id: ");
			userID = sc.nextLine();
			if (USER_ID_PATTERN.matcher(userID).find()) {
				if (checkDuplicateId(userID)) {
					System.err.println("This user id already existed!!");
				} else {
					break;
				}
			} else {
				System.out.println("User Id must be 6 digits");
			}
		}

		while (true) {
			System.out.println("Input user name: ");
			name = sc.nextLine();
			if (NAME_PATTERN.matcher(name).find()) {
				break;
			} else {
				System.err.println("Name must be 5 - 10 characters ");
			}
		}

		User user = new User(userID, name, null);
		userList.add(user);

	}

	public static void showUserInfo() {
		for (User user : userList) {
			user.displayInfo();
		}
	}

	// Show all Books
	public static void showAllBook() {
		System.out.println("Text Book:");
		for (TextBook textBook : textBookList) {
			textBook.displayInfo();
		}
		System.out.println("-----------------------------------------------------------");
		System.out.println("Reference Book: ");
		for (ReferenceBook referenceBook : refBookList) {
			referenceBook.displayInfo();
		}
	}

	public static void borrowBook() {

		System.out.println("Enter User Id: ");
		String id = sc.nextLine();
		User userCheck = findUserByID(id);
		if (userCheck != null) {
			showAllBook();
			System.out.println("Enter book title you want to borrow: ");
			String borrowBook = sc.nextLine();
			Book book = findBookByTitle(borrowBook);
			if (book != null) {
				userCheck.borrow(book);
				removeBook(book);
				System.out.println("Borrow book successfully!!");
			} else {
				System.err.println("Invalid Book!!!");
			}
		} else {
			System.err.println("User not found!!!");
		}

	}

	public static void returnedBook() {
		System.out.println("Enter User Id: ");
		String id = sc.nextLine();
		User userCheck = findUserByID(id);
		if (userCheck != null) {
			showUserInfo();
			System.out.println("Enter book title you want to returned: ");
			String returnedBook = sc.nextLine();
			Book book = findBookByTitle(returnedBook);
			if (book != null) {
				userCheck.returned_book(book);
				addBook(book);
				System.out.println("Returned book successfully!!");
			} else {
				System.err.println("Invalid Book!!!");
			}
		} else {
			System.err.println("User not found!!!");
		}
	}

	public static User findUserByID(String id) {
		for (User user : userList) {
			if (user.getUser_id().equals(id)) {
				return user;
			}
		}
		return null;
	}

	public static Book findBookByTitle(String title) {
		for (TextBook textBook : textBookList) {
			if (textBook.getTitle().equalsIgnoreCase(title)) {
				return textBook;
			}
		}
		for (ReferenceBook refBook : refBookList) {
			if (refBook.getTitle().equalsIgnoreCase(title)) {
				return refBook;
			}
		}
		return null;
	}

	public static void removeBook(Book book) {
		if (book instanceof TextBook) {
			textBookList.remove(book);
		} else if (book instanceof ReferenceBook) {
			refBookList.remove(book);
		}
	}

	public static void addBook(Book book) {
		if (book instanceof TextBook) {
			textBookList.add((TextBook) book);
		} else if (book instanceof ReferenceBook) {
			refBookList.add((ReferenceBook) book);
		}
	}

	public static boolean checkDuplicateId(String id) {
		for (User user : userList) {
			if (user.getUser_id().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkDuplicateISBN(String isbn) {
		for (TextBook textBook : textBookList) {
			if (textBook.getIsbn().equals(isbn)) {
				return true;
			}
		}

		for (ReferenceBook referenceBook : refBookList) {
			if (referenceBook.getIsbn().equals(isbn)) {
				return true;
			}
		}
		return false;
	}

}
