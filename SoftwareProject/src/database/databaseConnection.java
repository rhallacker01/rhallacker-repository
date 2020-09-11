package database;
import java.sql.*;

public class databaseConnection {
	
	public static Connection connectDB()throws SQLException, ClassNotFoundException {
		
		//Load the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Connect to DB
		String strConnect = "jdbc:mysql://localhost/mydb";
		Connection connection = DriverManager.getConnection(strConnect, "root", "" );
		return connection;
	}
	
	
}
