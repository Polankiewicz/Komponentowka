package zad6.Zadanie6;


public interface BookDao {

	public void writeListToFile(Ksiegarnia ksiegarnia, String file);
	public Ksiegarnia readListFromFile(String file);
}
