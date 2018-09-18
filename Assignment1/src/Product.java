public class Product
{
	//Fields
	private String prod_name;
	private double prod_price;
	private int prod_quantity;
	//Constructor
	public Product(String prod_name, double prod_price, int prod_quantity)
	{
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_quantity = prod_quantity;
	}
	//Getters
	public String getProd_name() { return prod_name; }
	public double getProd_price() { return prod_price; }
	public int getProd_quantity() { return prod_quantity; }
	//Setters
	public void setProd_name(String prod_name) { this.prod_name = prod_name; }
	public void setProd_price(double prod_price) { this.prod_price = prod_price; }
	public void setProd_quantity(int prod_quantity) { this.prod_quantity = prod_quantity; }
}
