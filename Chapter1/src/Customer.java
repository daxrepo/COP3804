public class Customer
{
	private Name name;
	private String acc_no;
	private Address address;

	public Customer(Name n, String ac, Address addr)
	{
		name = n;
		acc_no = ac;
		this.address = addr;
	}

	public Name getName()
	{
		return name;
	}

	public Address getAddress()
	{
		return address;
	}

	public String getAccountNumber()
	{
		return acc_no;
	}

	void changeAccoutNumber(String acc)
	{
		acc_no = acc;
	}
}
