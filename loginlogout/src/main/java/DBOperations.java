import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBOperations {
	private static Connection con = null;
	private static void connect()
	{
		try {
			String url = "jdbc:mysql://localhost:3306/java330";
			String uname = "root";
			String upass = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, upass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean register(String email, String password)
	{
		boolean b = true;
		connect();
		try {
			PreparedStatement ps= con.prepareStatement("insert into user1 value(?,?)");
			ps.setString(2, password);
			ps.setString(1, email);
			b = ps.execute();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return !b;
	}
	
	public static boolean login(String email, String password)
	{
		boolean b = false;
		connect();
		try {
			PreparedStatement ps= con.prepareStatement("select * from user1 where email = ? and password = ?");
			ps.setString(2, password);
			ps.setString(1, email);
			ResultSet rs  = ps.executeQuery();
			b = rs.next();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
