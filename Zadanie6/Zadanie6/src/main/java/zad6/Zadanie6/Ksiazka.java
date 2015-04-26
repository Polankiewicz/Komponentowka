package zad6.Zadanie6;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Hello world!
 *
 */
public class Ksiazka implements Comparable<Ksiazka>, Cloneable, Serializable
{
	private String title;
	private String author;
	private String genre;
	private int ISBN;
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public Ksiazka(String title, String author, String genre, int ISBN)
	{
		this.title=title;
		this.author=author;
		this.genre=genre;
		this.ISBN=ISBN;
	}
		
	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("title", title).
				append("author", author).append("genre", genre).append("ISBN", ISBN).toString();
	}
	
    public int compareTo(Ksiazka k) 
    {
        int porownaniAutorzy = author.compareTo(k.author);
 
        if(porownaniAutorzy == 0) {
            return title.compareTo(k.title);
        }
        else {
            return porownaniAutorzy;
        }
    }
    

	public String getTitle()
	{
		return title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public int getISBN()
	{
		return ISBN;
	}
	
}
