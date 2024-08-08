package baitap04;

public class CheckingAccount extends BankAccount {
	private double overdraft_limit;

	public CheckingAccount(String account_number, String account_holder,double balance, double overdraft_limit) {
		super(account_number, account_holder, balance);
		this.overdraft_limit = overdraft_limit;
	}

	public double getOverdraft_limit() {
		return overdraft_limit;
	}

	public void setOverdraft_limit(double overdraft_limit) {
		this.overdraft_limit = overdraft_limit;
	}

	@Override
	public void withdraw(double amount) {

		this.overdraft_limit = overdraft_limit - amount;
	}

	@Override
	public void display_Info() {
		System.out.printf("|%8s|%-12s|%4.1f|", super.getAccount_number(), super.getAccount_holder(),
				this.overdraft_limit);
		System.out.println("");
	}

	public boolean checkMoney() {
		if (this.overdraft_limit < 0) {
			return true;
		}
		return false;

	}

}
