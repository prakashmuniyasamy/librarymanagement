package com.libraries;
import java.util.*;
import java.sql.*;

public class Main {


Libjdbc con=new Libjdbc();
	
	public void initial() {
	System.out.println("1.Add Book");
		System.out.println("2.Display Book");
		System.out.println("3.Update Book");
		System.out.println("4.Delete Book");

			for(int i=0;i<1000;i++) {
		Scanner sc = new Scanner(System.in);
				
		int choose = sc.nextInt();
			
			switch(choose) {
			case 1 :
				
				    add();
				 
			    	break;
			case 2 :
				
					display();
				
			     	break;
			case 3 :
				
			      update();
				
		        	break; 
			case 4 :
			    
			      delete();
		        	break;
			}

		}
	}
	
	public void add() {
	try {
		
		Scanner sc = new Scanner(System.in);
		
		 PreparedStatement ps=con.connect.prepareStatement("insert into book values(?,?,?,?)");
		
	    System.out.println("enter sno");
				int sno=sc.nextInt();
		System.out.println("enter book name");
		       String bookname=sc.next();
		System.out.println("enter price");
		       int price=sc.nextInt();
		System.out.println("enter authorname");
	         	String authorname=sc.next();

		ps.setInt(1, sno);
		ps.setString(2,bookname);
		ps.setInt(3,price);
		ps.setString(3, authorname);
		
		int i=ps.executeUpdate();
		System.out.println("added successfully");
		
		System.out.println("Enter options"+"  "+"1-add"+"  "+"2-display"+"  "+"3-update"+"  "+"4-delete");
	}catch(Exception e) {
	System.out.println(e);	
	}
	}
	
	public void display() {
	try {
		  Scanner sc = new Scanner(System.in);
	      PreparedStatement ps=con.connect.prepareStatement("select*from librarym.book");
	
          ResultSet rs=ps.executeQuery();
	
	while(rs.next()) {
		
	     System.out.println(rs.getInt(1)+"  "+rs.getString(2) +"  "+rs.getInt(3)+"  "+rs.getString(4));	
	  
	}
	}catch(Exception e) {
		 System.out.println(e);
	}
	   System.out.println("Enter options"+"  "+"1-add"+"  "+"2-display"+"  "+"3-update"+"  "+"4-delete");
	}
	
	
	public void update() {
		
	try {	
		Scanner sc = new Scanner(System.in);
		
	
		PreparedStatement ps=con.connect.prepareStatement("update book set bookname=?"+",price=?,authorname=? where sno=?");  
		
		System.out.println("Enter sno");
		ps.setInt(4, sc.nextInt());
		
		System.out.println("book name");
		ps.setString(1,sc.next());  
		
		System.out.println("price");
		ps.setInt(3,sc.nextInt() );
		
		System.out.println("authorname");
		ps.setString(2,sc.next());
		  
		 ps.executeUpdate();   
		  
		
		System.out.println(" records updated");
		System.out.println("Enter options"+"  "+"1-add"+"  "+"2-display"+"  "+"3-update"+"  "+"4-delete");
	}catch(Exception e) {
		System.out.println(e);
	}
	}
public void delete()  {
	try {	
		Scanner sc = new Scanner(System.in);
	
		PreparedStatement ps=con.connect.prepareStatement("delete from book where sno=?");  
		
		System.out.println("enter book sno");
		ps.setInt(1,sc.nextInt());  
		  
		ps.executeUpdate();  
		System.out.println(" records deleted"); 
		System.out.println("Enter options"+"  "+"1-add"+"  "+"2-display"+"  "+"3-update"+"  "+"4-delete");
	}catch(Exception e) {
		System.out.println(e);
	}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Main col=new Main();
	col.initial();
}
	}

	


