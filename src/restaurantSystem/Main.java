package restaurantSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
public static void main(String[] args) {
	try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_system","root" ,"root");
	System.out.println("hi");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
