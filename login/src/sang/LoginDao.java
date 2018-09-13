package sang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	String sql ="SELECT * FROM LOGIN WHERE USERNAME=? AND PASSWORD=?";
	String sql1 ="INSERT INTO LOGIN VALUES (?,?)";
	String uname="sa";
	String pass="";
	String url="jdbc:h2:~/test";
	
	public boolean check(String username,String password)
	{
		try {
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
			{
				return true;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
		return false; 		
	}
	public boolean register(String username,String password)
	{
		try {
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			int t = pstmt.executeUpdate();
			if (t==0)
			{
				return true;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
		return false; 		
	}

}
