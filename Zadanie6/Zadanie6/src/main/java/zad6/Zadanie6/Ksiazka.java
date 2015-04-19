package zad6.Zadanie6;

public class Ksiazka {

	private String title;
	private String author;
	private String genre;
	private int ISBN;
	
	
	public Ksiazka(String title, String author, String genre, int ISBN)
	{
		this.title=title;
		this.author=author;
		this.genre=genre;
		this.ISBN=ISBN;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
	
	public int getISBN()
	{
		return ISBN;
	}
	
	public void setISBN(int ISBN)
	{
		this.ISBN = ISBN;
	}
	
}
