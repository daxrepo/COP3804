//package

import java.text.DateFormat;
import java.util.Date;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.ArrayList;

public class TestBank
{
	public static void main(String[] args)
	{
		Database db = new Database();
		Database close = new Database();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		Date now = new Date();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		boolean done = false;

		while (!done)
		{
			int menu = GetData.getInt("\tUnited Bank of Java\n" + "\t" + df.format(now) + "\n" +
					"\nPlease Choose From the Following" + "\n1. Create New Account\n2. Update Existing Account " +
					"\n3. Close an Account\n4. View Account Information\n5. Exit");

			switch (menu)
			{
				case 1: //Creating a BankAccount object and storing it in the database
					//Creating Name object
					String f = GetData.getWord("Enter First Name");
					String l = GetData.getWord("Enter Last Name");
					Name n = new Name(f, l);
					//Creating Address object
					String str = GetData.getWord("Enter Street Name");
					String city = GetData.getWord("Enter City");
					String st = GetData.getWord("Enter State");
					String zip = GetData.getWord("Enter ZIP");
					//Creating Customer object
					Address addr = new Address(str, city, st, zip);
					String accNo = GetData.getWord("Enter Account Number");
					Customer c = new Customer(n, accNo, addr);
					//Creating BankAccount object
					double amount = GetData.getDouble("Enter First Deposit");
					BankAccount ba = new BankAccount(c, amount);
					//Adding BankAccount object to the database
					db.add(ba);

					break;

				case 2: //Update Account
					accNo = GetData.getWord("Enter Account Number of Account you'd like to update");
					db.search(accNo);
					if (!db.inList())
					{
						JOptionPane.showMessageDialog(null, "Account not found.");
					}
					else
					{
						int option = GetData.getInt("Would you like to (1) Deposit, (2) Withdraw");
						switch (option)
						{
							case 1:
								double amt = GetData.getDouble("Enter amount you'd like to deposit");
								BankAccount b = db.getAccount();
								b.deposit(amt);
								break;
							case 2:
								double amnt = GetData.getDouble("Enter the amount you'd like to withdraw");
								BankAccount bnk = db.getAccount();
								if (!bnk.isSufficient(amnt))
								{
									JOptionPane.showMessageDialog(null, "Insufficient funds, withdraw cannot be done.");
								}
								else
								{
									bnk.withdraw(amnt);
								}
								break;
							default:
								JOptionPane.showMessageDialog(null, "Invalid selection. To return to main menu, please deposit or withdraw $50.");
								break;
						}

					}
					break;

				case 3: //Close account
					accNo = GetData.getWord("Close account - Please enter Account No.");
					db.search(accNo);
					if (!db.inList())
					{
						JOptionPane.showMessageDialog(null, "Account not found.");
					}
					else
					{
						BankAccount b = db.getAccount();
						int index = db.getIndex();
						db.add(db.delete(index));
						JOptionPane.showMessageDialog(null, "The account " + accNo + "has been closed.");
					}
					break;

				case 4: //View Account
					int view = GetData.getInt("What information would you like to view?\n1. Single account\n2. All active accounts\n3. All inactive accounts\n");

					switch (view)
					{
						case 1: //View a single account
							accNo = GetData.getWord("View account. Please enter Account No.");
							db.search(accNo);
							if (!db.inList())
							{
								JOptionPane.showMessageDialog(null, "Account not found.");
							}
							else
							{
								BankAccount bb = db.getAccount();
								String s = "Customer\t" + bb.getCustomer().getName().getFirst() + "\t" + bb.getAmount();
								JOptionPane.showMessageDialog(null, s, "Bank Account " + bb.getCustomer().getAccountNumber(), JOptionPane.INFORMATION_MESSAGE);
							}
							break;
						case 2: //View all active accounts
							ArrayList list = db.getList();
							if (list.isEmpty())
							{
								JOptionPane.showMessageDialog(null, "List is empty.");
							}
							else
							{
								int i = 0, length = db.getSize();
								String s = "";
								while (i < length)
								{
									BankAccount b = (BankAccount) list.get(i);
									s = s + "Customer Name: " + b.getCustomer().getName().getFirst() + " " + b.getCustomer().getName().getLast() + "\nAccount number: "
											+ b.getCustomer().getAccountNumber() + "\n" + b.getCustomer().getAddress().getStreet() + ", " + b.getCustomer().getAddress().getCity()
											+ ", " + b.getCustomer().getAddress().getState() + "," + b.getCustomer().getAddress().getZip() + "\n"
											+ nf.format(b.getAmount()) + "\n";
									i++;
								}
								display(s, "Active Accounts", JOptionPane.INFORMATION_MESSAGE);
							}
							break;
						case 3: //View all closed accounts
							ArrayList closed = db.getList();

							if (closed.isEmpty())
							{
								JOptionPane.showMessageDialog(null, "List is empty.");
							}
							else
							{
								int i = 0, length = db.getSize();
								String s = "";

								while (i < length)
								{
									BankAccount b = (BankAccount) closed.get(i);
									s = s + "Name " + b.getCustomer().getName().getFirst() + " "
											+ b.getCustomer().getName().getLast() + "\tAccount Number: "
											+ b.getCustomer().getAccountNumber() + "\n";
									i++;
								}
								display(s, "Closed Accounts", JOptionPane.INFORMATION_MESSAGE);
							}
							break;
						default:
							JOptionPane.showMessageDialog(null, "Invalid Option.");
							break;

					}
					break;
				case 5:
					done = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Account not found.");
					break;

			}

		}
	}

	static void display(String s, String heading, int MESSAGE_TYPE)
	{
		JTextArea text = new JTextArea(s, 20, 30);
		JScrollPane pane = new JScrollPane(text);
		JOptionPane.showMessageDialog(null, pane, heading, MESSAGE_TYPE);
	}

}
