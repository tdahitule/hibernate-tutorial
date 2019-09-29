package com.luvtocode.hbtutorial;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class TestJdbc {


	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		try {
			System.out.println("Connecting to database...");
			Connection myConn = DriverManager.getConnection(jdbcUrl, "tushar", "asdf1234");
			System.out.println("Connection Successfull..!!!");
			myConn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
