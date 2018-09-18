public class Address
{
	String street, city, state, zip;

	Address(String str, String city, String st, String zip)
	{
		street = str;
		this.city = city;
		state = st;
		this.zip = zip;
	}

	String getStreet()
	{
		return street;
	}

	String getCity()
	{
		return city;
	}

	String getState()
	{
		return state;
	}

	String getZip()
	{
		return zip;
	}
}
