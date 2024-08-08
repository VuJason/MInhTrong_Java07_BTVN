package baitap04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankAccountApplication {
	private static List<SavingsAccount> savingList = new ArrayList<>();
	private static List<CheckingAccount> checkingList = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	private static final Pattern ID_PATTERN = Pattern.compile("^[0-9]{8}$");
	private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]{5,10}");

	public static void main(String[] args) {
		int choice = 0;
		do {
			System.out.println("1. Create Bank Account");
			System.out.println("2. Savings Account");
			System.out.println("3. Checking Account");
			System.out.println("4. Exit");
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				int accountChoice = 0;
				do {
					System.out.println("Bank Account Management:");
					System.out.println("1. Create Savings Account");
					System.out.println("2. Create Checking Account");
					System.out.println("3. Back");
					System.out.println("Enter your choice: ");
					accountChoice = Integer.parseInt(sc.nextLine());
					if (accountChoice == 1) {
						inputSavingAccount();
					} else if (accountChoice == 2) {
						inputCheckingAccount();
					}
				} while (accountChoice != 3);
				break;
			case 2:
				int savingAccountChoice = 0;
				do {
					System.out.println("");
					System.out.println("Saving Account Management:");
					System.out.println("1. Show Acount Information");
					System.out.println("2. Deposit");
					System.out.println("3. Withdraw");
					System.out.println("4. Add Interest");
					System.out.println("5. Back");
					System.out.println("Enter your choice: ");
					savingAccountChoice = Integer.parseInt(sc.nextLine());
					if (savingAccountChoice == 1) {
						showSavingAccount();
					} else if (savingAccountChoice == 2) {
						deposit();
					} else if (savingAccountChoice == 3) {
						withdraw();
					} else if (savingAccountChoice == 4) {
						addInterest();
					}
				} while (savingAccountChoice != 5);
				break;
			case 3:
				int checkingAccountChoice = 0;
				do {
					System.out.println("");
					System.out.println("Checking Account Management:");
					System.out.println("1. Show Acount Information");
					System.out.println("2. Withdraw");
					System.out.println("3. Back");
					System.out.println("Enter your choice: ");
					checkingAccountChoice = Integer.parseInt(sc.nextLine());
					if (checkingAccountChoice == 1) {
						showCheckingAccount();
					} else if (checkingAccountChoice == 2) {
						withdrawCheckingAccount();
					}
				} while (checkingAccountChoice != 3);
				break;

			}
		} while (choice != 4);
	}

	public static void inputSavingAccount() {
		String account_number, accoung_holder;
		double balance = 0;
		final double interest_rate = 0.8;

		while (true) {
			System.out.println("Input account number: ");
			account_number = sc.nextLine();
			if (ID_PATTERN.matcher(account_number).find()) {
				break;
			} else {
				System.out.println("You need to input 8 digit for account number!!!");
			}
		}

		while (true) {
			System.out.println("Input account holder: ");
			accoung_holder = sc.nextLine();
			if (NAME_PATTERN.matcher(accoung_holder).find()) {
				break;
			} else {
				System.err.println("Name must be 5 to 10 characters!!!");
			}

		}

		boolean exist = false;
		for (SavingsAccount savingAccount : savingList) {
			if (savingAccount.getAccount_number().equals(account_number)) {
				exist = true;
				break;
			}
		}

		if (exist) {
			System.err.println("This account bank already exist!!");
		} else {
			SavingsAccount savingAccountList = new SavingsAccount(account_number, accoung_holder, balance,
					interest_rate);
			savingList.add(savingAccountList);
			System.out.println("Create account successfully!!!");
		}

	}

	public static void inputCheckingAccount() {
		String account_number, account_holder;
		double balance = 0, overdraft_limit = 2000000;
		while (true) {
			System.out.println("Input account number: ");
			account_number = sc.nextLine();
			if (ID_PATTERN.matcher(account_number).find()) {
				break;
			} else {
				System.out.println("You need to input 8 digit for account number!!!");
			}
		}
		while (true) {
			System.out.println("Input account holder: ");
			account_holder = sc.nextLine();
			if (NAME_PATTERN.matcher(account_holder).find()) {
				break;
			} else {
				System.err.println("Name must be 5-10 characters!!!");
			}
		}

		boolean exist = false;
		for (CheckingAccount checkingAccount : checkingList) {
			if (checkingAccount.getAccount_number().equals(account_number)) {
				exist = true;
				break;
			}
		}

		if (exist) {
			System.err.println("This account bank already exist!!!");
		} else {
			CheckingAccount checkingAccountList = new CheckingAccount(account_number, account_holder, balance,
					overdraft_limit);
			checkingList.add(checkingAccountList);
			System.out.println("Create account successfully!!!");
		}

	}

	public static void showSavingAccount() {
		for (SavingsAccount savingAccount : savingList) {
			savingAccount.display_Info();
		}
	}

	public static void showCheckingAccount() {
		for (CheckingAccount checkingAccount : checkingList) {
			checkingAccount.display_Info();
		}
	}

	public static void deposit() {
		String id;
		double depositMoney;
		System.out.println("Please, enter account number: ");
		id = sc.nextLine();
		SavingsAccount accountCheck = findAccountByID(id);
		if (accountCheck != null) {
			System.out.println("Enter amount you want to deposit: ");
			depositMoney = Double.parseDouble(sc.nextLine());
			accountCheck.deposit(depositMoney);
			System.out.println("Deposit Successfully!!!");
		} else {
			System.err.println("Invalid Account ID!!");
		}
	}

	public static void withdraw() {
		String id;
		double withdrawMoney;
		System.out.println("Please, enter account number: ");
		id = sc.nextLine();
		SavingsAccount accountCheck = findAccountByID(id);
		if (accountCheck != null) {

			System.out.println("Enter amount you want to withdraw: ");
			withdrawMoney = Double.parseDouble(sc.nextLine());
			if (accountCheck.checkMoney()) {
				System.err.println("Your balance is not enough to withdraw!!!");
			} else {
				accountCheck.withdraw(withdrawMoney);
				System.out.println("Withdraw Successfully!!!");
			}

		} else {
			System.err.println("Invalid Account ID!!!");
		}
	}

	public static void withdrawCheckingAccount() {
		String id;
		double withdrawMoney;
		System.out.println("Please, enter account number: ");
		id = sc.nextLine();
		CheckingAccount accountCheck = findCheckingAccountByID(id);
		if (accountCheck != null) {
			if (accountCheck.checkMoney()) {
				int rep = 0;
				System.err.println("Your balance minus!!!");
				do {
					System.out.println("Do you want to withdraw more ?");
					System.out.println("1. Yes");
					System.out.println("2. No");
					rep = Integer.parseInt(sc.nextLine());
					if (rep == 1) {
						System.out.println("Enter amount you want to withdraw: ");
						withdrawMoney = Double.parseDouble(sc.nextLine());
						accountCheck.withdraw(withdrawMoney);
						break;
					}
				} while (rep != 2);

			} else {
				System.out.println("Enter amount you want to withdraw: ");
				withdrawMoney = Double.parseDouble(sc.nextLine());
				accountCheck.withdraw(withdrawMoney);
				System.out.println("Withdraw Successfully!!!");
			}

		} else {
			System.err.println("Invalid Account ID!!!");
		}
	}

	public static CheckingAccount findCheckingAccountByID(String id) {
		for (CheckingAccount checkingAccount : checkingList) {
			if (checkingAccount.getAccount_number().equals(id)) {
				return checkingAccount;
			}
		}
		return null;
	}

	public static SavingsAccount findAccountByID(String id) {
		for (SavingsAccount savingAccount : savingList) {
			if (savingAccount.getAccount_number().equals(id)) {
				return savingAccount;
			}
		}
		return null;
	}

	public static void addInterest() {
		String id;
		int day;

		System.out.println("Please, enter account number: ");
		id = sc.nextLine();
		SavingsAccount accountCheck = findAccountByID(id);
		if (accountCheck != null) {
			if (accountCheck.checkMoney()) {
				System.err.println("You need to deposit!!");
			} else {
				System.out.println("Enter the number of days you want to receive interest: ");
				day = Integer.parseInt(sc.nextLine());
				double interest = (accountCheck.add_Interest()) * day;
				double total = interest + accountCheck.getBalance();
				System.out.println("Add Interest.......");
				System.out.printf("|%8s|Days: %4d|Interest: %4.1f VND|Total: %4.1f VND|",
						accountCheck.getAccount_number(), day, interest, total);

			}

		} else {
			System.err.println("Invalid Account ID!!");
		}
	}
}
