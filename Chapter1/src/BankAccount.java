public class BankAccount
{
	private double balance;
	private Customer cust;

	public BankAccount(Customer c, double amt)
	{
		cust = c;
		balance = amt;
	}

	public Customer getCustomer()
	{
		return cust;
	}

	public void deposit(double amt)
	{
		balance += amt;
	}

	public void withdraw(double amt)
	{
		balance -= amt;
	}

	public double getAmount()
	{
		return balance;
	}

	public boolean isSufficient(double amt)
	{
		return balance >= amt;
	}
}
