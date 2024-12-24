package com.mgmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SchoolService {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String pwd="123";
	 static Connection con;
	 Scanner sc=new Scanner(System.in);
static {
	try {
	Class.forName("org.postgresql.Driver");
	
	con=DriverManager.getConnection(url, user, pwd);
	
	
}
	catch(ClassNotFoundException e){
} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public int save() {
	int no=0;
	String sql="insert into student values(?,?,?,?,?)";
	try {
	
		
		PreparedStatement pstm=con.prepareStatement(sql);
System.out.println("Enter id");
int id=sc.nextInt();
System.out.println("Enter Name");
String name=sc.next();
System.out.println("Enter age");
int age=sc.nextInt();
System.out.println("Enter email");
String email=sc.next();
System.out.println("Enter course");
String course=sc.next();
pstm.setInt(1,id);
pstm.setString(2,name);
pstm.setInt(3,age);
pstm.setString(4,email);
pstm.setString(5,course);
 no=pstm.executeUpdate();
con.close();


	
}
	
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return no;
}

public int update() {
	int no=0;
	String sql="update student set age=? where id=?";
	try {
		PreparedStatement pstm=con.prepareStatement(sql);
		System.out.println("Enter Updated age");
		int age=sc.nextInt();
		System.out.println("Enter ID of the student");
		int id=sc.nextInt();

	
		
	pstm.setInt(1,age);
		
		pstm.setInt(2,id);
		 no=pstm.executeUpdate();
		con.close();
		
		
		
	}
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return no;
}

public int delete() {
	int no=0;
	String sql="delete from student where id=?";
	try {
		
		PreparedStatement pstm=con.prepareStatement(sql);
		System.out.println("Enter the student id which you want to delete");
		int id=sc.nextInt();
		pstm.setInt(1,id);
		 no=pstm.executeUpdate();
		con.close();
		return no;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return no;
}
public void fetch()
{
	try {
	Statement statement =con.createStatement();
	String sql="SELECT * from Student";
	
	
	ResultSet rs=statement.executeQuery(sql);
	while(rs.next())
	{int id=rs.getInt(1);
	String name=rs.getString(2);
	int age=rs.getInt(3);
	String email=rs.getString(4);
	String course=rs.getString(5);
	System.out.println(id);
	System.out.println(name);
	System.out.println(age);
	System.out.println(email);
	System.out.println(course);
	System.out.println("--------------");
	con.close();
	}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}
}