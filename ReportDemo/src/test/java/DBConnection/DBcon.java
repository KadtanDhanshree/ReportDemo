package DBConnection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBcon
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 	
	{
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/finsys", "root", "admin");
		Statement stmt=con.createStatement();
		ResultSet res=stmt.executeQuery("select *from cities");
		while(res.next())
		{
			System.out.println(res.getString("cityname"));
			System.out.println(res.getString("statename"));
		}
	}

}

