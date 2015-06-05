package Organizer.Organizer.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlOperations 
{
	private NotesList notesList;
	
	public SqlOperations(NotesList notesList)
	{
		this.notesList = notesList;
	}
	
	public void Save()
	{
		try
	    {
		    // Step 1: Load the JDBC driver. 
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		    // Step 2: Establish the connection to the database. 
		    String url = "jdbc:sqlserver://DAMIAN-LENOVO;databaseName=CalendarDataBase;integratedSecurity=true";
	
		    Connection conn = DriverManager.getConnection(url,"user1", null);
		    Statement stmt = conn.createStatement();
		    
		    // clear database
		    //notesList = Load();
		    String sql_clear = "DELETE FROM CalendarDataBaseTable";
		    stmt.executeUpdate(sql_clear);
		      
		    // save to database
		    for(int i=0; i<notesList.size(); i++)
		    {
		    	String sql_insert = "INSERT INTO CalendarDataBaseTable VALUES (\'" + notesList.getNote(i).getStringFromDate() 
		    			+ "\',\'" + notesList.getNote(i).getPlace() + "\',\'" 
		    			+ notesList.getNote(i).getDescription() + "\')";
		    	stmt.executeUpdate(sql_insert);
		    }
	    }
	    catch (Exception e)
	    {
		    System.err.println("Got an exception! "); 
		    System.err.println(e.getMessage()); 
		    e.printStackTrace();
	    } 
	}
	
	public NotesList Load()
	{
		try
	    {
		    // Step 1: Load the JDBC driver. 
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		    // Step 2: Establish the connection to the database. 
		    String url = "jdbc:sqlserver://DAMIAN-LENOVO;databaseName=CalendarDataBase;integratedSecurity=true";
	
		    Connection conn = DriverManager.getConnection(url,"user1", null);
		    Statement stmt = conn.createStatement();
		      
		    // display result
		    String sql = "SELECT * FROM CalendarDataBaseTable";
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    // load to collection
		    while(rs.next()) 
		    { 
		    	Note n = new Note();
		    	n.setStringFromDate(rs.getString("date_id"));
		    	n.setPlace(rs.getString("place_data"));
		    	n.setDescription(rs.getString("description_data"));
		    	
		    	// if note is duplicated - ignore it
		    	boolean isDuplicatedNote = false;
		    	for(int i=0; i<notesList.size(); i++)
		    	{
		    		if(notesList.getNote(i).getStringFromDate().equals(n.getStringFromDate()))
		    		{
		    			isDuplicatedNote = true;
		    			break;
		    		}
		    	}
		    	if(!isDuplicatedNote)
		    		notesList.addNote(n);
		    }
	    }
	    catch (Exception e)
	    {
		    System.err.println("Got an exception! "); 
		    System.err.println(e.getMessage()); 
		    e.printStackTrace();
	    } 
		
		return notesList;
	}
}
