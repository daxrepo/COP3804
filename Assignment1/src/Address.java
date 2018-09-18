public class Address
{
	//Fields
	String street, city, state, zip;
	//Constructor
	Address(String str, String city, String st, String zip)
	{
		this.street = str;
		this.city = city;
		this.state = st;
		this.zip = zip;
	}
	//Setters
	public void setStreet(String street) { this.street = street; }
	public void setCity(String city) { this.city = city; }
	public void setState(String state) { this.state = state; }
	public void setZip(String zip) { this.zip = zip; }
	//Getters
	public String getStreet()
	{
		return street;
	}
	public String getCity()
	{
		return city;
	}
	public String getState()
	{
		return state;
	}
	public String getZip()
	{
		return zip;
	}
}
