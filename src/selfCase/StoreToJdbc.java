package selfCase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;



public class StoreToJdbc {
	 static final String JDBC_DRIVER = "org.h2.Driver"; 
	 static Connection con;
	
	public void saveMailDetails(MailDetails maildetails) throws ClassNotFoundException {
		String insertItemQuery = "INSERT INTO SELF_DETAILS VALUES(?, ?, ?)";
		
		try {  
				Class.forName(JDBC_DRIVER);
				ResourceBundle rb = ResourceBundle.getBundle("selfCase//db", Locale.US);
				String url = rb.getString("jdbcUrl");
				String un = rb.getString("userName");
				String pass = rb.getString("password");
				Connection con = DriverManager.getConnection(url,un,pass);
				PreparedStatement pstmt = con.prepareStatement(insertItemQuery);

			pstmt.setString(1, maildetails.getEmail());
			pstmt.setString(2, maildetails.getSubject());
			pstmt.setString(3, maildetails.getMessage());

			int recordInserted = pstmt.executeUpdate();
			if(recordInserted==1)
			{
				System.out.println("Saved Successfully");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
