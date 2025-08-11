package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from seller");
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + " , " + rs.getString("Name"));
			}
			
		
		

		}
		catch (SQLException e) {
			System.out.println(e.getStackTrace());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(stmt);
			DB.closeConnection();
		}

	}
}
