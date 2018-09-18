import java.util.ArrayList;

public class Database
{
	ArrayList<BankAccount> list;
	BankAccount ba;
	int index;
	boolean found;

	Database()
	{
		list = new ArrayList<BankAccount>();
	}

	void search(String key)
	{
		found = false;
		int i = 0;

		while (!found && i < list.size())
		{
			BankAccount b = list.get(i);
			if (b.getCustomer().getAccountNumber().equalsIgnoreCase(key))
			{
				ba = b;
				found = true;
				index = i;
			} else i++;

		}
	}

	void add(BankAccount b)
	{
		list.add(b);
	}

	BankAccount delete(int i)
	{
		return list.remove(i);
	}

	int getIndex()
	{
		return index;
	}

	boolean inList()
	{
		return found;
	}

	BankAccount getAccount()
	{
		return ba;
	}

	int getSize()
	{
		return list.size();
	}

	boolean isEmpty()
	{
		return list.isEmpty();
	}

	ArrayList getList()
	{
		return list;
	}


}
