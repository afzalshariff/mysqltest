package com.connectectivity.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlInsert {

	public static void main(String args[])  {

		try{
			Class.forName("com.mysql.jdbc.Driver"); 
		} catch (Exception e) {
			System.out.println("Error While connecting to Driver");
			e.printStackTrace();
		}

		Connection con = null;
		try {
			String url ="jdbc:mysql://myrdsinstance.c4vfq4x8xx4n.us-west-2.rds.amazonaws.com:3306/myrdsinstance";
			String username = "myrdsinstance";
			String password = "myrdsinstance";
			con = DriverManager.getConnection(url,username,password);

		} catch(SQLException e){
			System.out.println("Connection Failed! Please Check console");
			e.printStackTrace();
		}

		if(con != null) {
			try{
				Statement stm = con.createStatement();
				String sql = "INSERT INTO user VALUES('awsTest','aws@test.com','aws123',current_timestamp)";
				int count= 	stm.executeUpdate(sql);
				System.out.println(count +"new record/records are inserted");

				String sql2 = "select * from user";
				ResultSet rs = stm.executeQuery(sql2);
				while(rs.next()){
					String user = rs.getString(1);
					String mail = rs.getString(2);
					String pswrd = rs.getString(3);
					String curTime = rs.getString(4);

					System.out.println(user+"   " + mail +"   " + pswrd+ "   " + curTime);
				} 

				con.close();
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

