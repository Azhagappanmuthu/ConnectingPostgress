package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostgresConnection {

	public static void main(String args[]) {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentProfile", "postgres",
					"postgres");
			connection.setAutoCommit(false);
			System.out.println("opened database succesfully");
			statement = connection.createStatement();
			String sql = "INSERT INTO STUDENTSDETAILS (ID,NAME,AGE,ADDRESS) " + "VALUES (2001, 'AJITH', 15, 'MADURAI');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO STUDENTSDETAILS (ID,NAME,AGE,ADDRESS) " + "VALUES (2002, 'SAKTHI', 16, 'TRICHY');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO STUDENTSDETAILS (ID,NAME,AGE,ADDRESS) " + "VALUES (2003, 'RAMESH', 15, 'OOTY');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO STUDENTSDETAILS (ID,NAME,AGE,ADDRESS) " + "VALUES (2004, 'TAMIL', 15, 'MYSORE');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO STUDENTSDETAILS (ID,NAME,AGE,ADDRESS) " + "VALUES (2005, 'NAVEEN', 15, 'CHENNAI');";
			statement.executeUpdate(sql);

			
			statement.close();
			connection.commit();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records Created Successfully");

	}

}
