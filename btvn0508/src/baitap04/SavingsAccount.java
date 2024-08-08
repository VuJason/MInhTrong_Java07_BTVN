package baitap04;

public class SavingsAccount extends BankAccount {
	private double interest_rate;

	public SavingsAccount(String account_number, String account_holder, double balance, double interest_rate) {
		super(account_number, account_holder, balance);
		this.interest_rate = interest_rate;
	}

	public double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}

	@Override
	public void display_Info() {
		System.out.printf("|%8s|%-12s|%4.1f|", super.getAccount_number(), super.getAccount_holder(),
				super.getBalance());
		System.out.println();
	}

	public boolean checkMoney() {
		if (super.getBalance() == 0 || super.getBalance() < 0) {
			return true;
		}
		return false;

	}

	public double add_Interest() {
		return (this.interest_rate * super.getBalance()) / 365;
	}

}
