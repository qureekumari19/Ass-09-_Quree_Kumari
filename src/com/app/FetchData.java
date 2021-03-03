package com.app;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.app.Movies;
public class FetchData {
	public static List<Movies> populateMovies(File file) throws FileNotFoundException, ParseException
	{
		List<Movies> list=new ArrayList<Movies>();	
		  Scanner sc=new Scanner(file);
		  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String text[] = null;						
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
			return list;
	}
	public static void getMoviesRealeasedInYear(int year) throws FileNotFoundException, ParseException
	{
		File file=new File("src/com/app/MovieDetails");	
		Scanner sc=new Scanner(file);
		String text[] = null;		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		while(sc.hasNextLine())
		{			
			text=sc.nextLine().split(",");			
			int y=df.parse(text[4]).getYear()+1900;			
			if(year==y)
			{				
				System.out.println(text[0]+" "+text[1]+" "+text[2]);
			}			
		}	
	}
	public static void getMoviesByActor(List<Movies> m,String actor)
	{
		Iterator it=m.iterator();
		while(it.hasNext())
		{
			Movies e=(Movies) it.next();
			if(e.getCasting().contains(actor))
			    System.out.println(e.toString());
		}
	}
	public static void addMovie(Movies movie,List<Movies> movies)
	{
		int s=movies.size();
		movies.add(movie);
		if(s<movies.size())
			System.out.println(movie.toString());
		else
			System.out.println("Data has not added");
		
		
	}	
	public static Set<Movies> businessDone(double amount,List<Movies> m)
	{
		Set<Movies> s=new HashSet<>();
		Iterator it=m.iterator();
		while(it.hasNext())
		{
			Movies e=(Movies) it.next();
			if(e.getTotalBusinessDone()>amount)
			    s.add(e);
		}
		return s;
		
	}
	public static void updateRatings(String movieName, double rating ,List<Movies> movies)
	{		
		Iterator it=movies.iterator();
		while(it.hasNext())
		{
			Movies e=(Movies) it.next();
			if(e.getMovieName().equals(movieName))
			{
				e.setRating(rating);
				System.out.println("Rating Updated");
				System.out.println(e.toString());
			}
		}		
	}
	public static void updateBusiness(String movieName, double amount,List<Movies> movies)
	{
		Iterator it=movies.iterator();
		while(it.hasNext())
		{
			Movies e=(Movies) it.next();
			if(e.getMovieName().equals(movieName))
			{
				e.setTotalBusinessDone(amount);
				System.out.println("TotalBusinessCost Updated");
				System.out.println(e.toString());
			}
		}	
	}
    public static void main(String[] args) throws FileNotFoundException, ParseException {
		File file=new File("src/com/app/MovieDetails");
		List<Movies> list=new ArrayList<Movies>();
		list=populateMovies(file);
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			Movies e=(Movies) it.next();
			System.out.println(e.toString());
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Movies m=new Movies();		
		m.setMovieId(10);
		m.setMovieName("Kulfi Kumar");
		m.setMovieType("YGrade");
		m.setLanguage("Hindi");
		m.setReleaseDate(df.parse("10/09/2002"));
		m.setCasting(new ArrayList<>(Arrays.asList("wrf")));
		m.setRating(Double.valueOf("4.87"));
		m.setTotalBusinessDone(Double.valueOf("6742659"));		
		addMovie(m,list);
		System.out.println("1-------------");
		getMoviesRealeasedInYear(2002);
		System.out.println("2-------------");
		getMoviesByActor(list, "abc");
		Set<Movies> s=new HashSet<>();
		s=businessDone(10000.0,list);
		it=s.iterator();
		System.out.println("3-------------");
		while(it.hasNext())
		{
			Movies m1=(Movies) it.next();
			System.out.println(m1.toString());
		}		
		System.out.println("4-------------");
		updateRatings("Annum", 3.6, list);
		System.out.println("5-------------");
		updateBusiness("Annum", 56789, list);
	}
}
