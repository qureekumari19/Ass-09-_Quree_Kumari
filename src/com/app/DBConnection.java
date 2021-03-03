package com.app;
import com.app.Movies;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DBConnection {
	static String url="jdbc:mysql://localhost:3306/emp1";
	static String driverClass="com.mysql.jdbc.Driver";
	static String use="system";
	static String pwd="root";
	static Connection con;
	public static void allAllMoviesInDb(List<Movies> movies)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection(url,use,pwd);
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create table movies(movieid int, moviename varchar(50), movieType varchar(30),Language varchar(10), ReleaseDate date,Rating int(2,2),TotalBusiness int(8,2))");			
            Iterator i=movies.iterator();
            while(i.hasNext())
            {
            	Movies m=(Movies) i.next();
            	String sql="Insert into movies values("+m.getMovieId()+m.getMovieName()+m.getMovieType()+m.getLanguage()+m.getReleaseDate()+m.getRating()+m.getTotalBusinessDone()+")";
            	stmt.executeUpdate(sql);
            }
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
  public static void main(String[] args) throws FileNotFoundException, ParseException {
	  File file=new File("src/com/app/MovieDetails");	
		Scanner sc=new Scanner(file);
		String text[] = null;	
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Movies> list=new ArrayList<>();
		while(sc.hasNextLine())
		{
			Movies m=new Movies();
			text=sc.nextLine().split(",");
			m.setMovieId(Integer.valueOf(text[0]));
			m.setMovieName(text[1]);
			m.setMovieType(text[2]);
			m.setLanguage(text[3]);
			m.setReleaseDate(df.parse(text[4]));
			m.setCasting(new ArrayList<>(Arrays.asList(text[5].split(","))));
			m.setRating(Double.valueOf(text[6]));
			m.setTotalBusinessDone(Double.valueOf(text[7]));
			list.add(m);			
		}	
		allAllMoviesInDb(list);
   }
}
