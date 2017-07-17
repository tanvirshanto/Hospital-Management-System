package Classes;


	import java.sql.Connection;
	import java.sql.DriverManager;

	import javax.swing.JOptionPane;

	public class DatabaseConnect {
		Connection conn=null;
	public static Connection dbConnector(){
		
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/log_info","root","");
		//JOptionPane.showMessageDialog(null, "Connection successes");
		return conn;
	}

	catch(Exception e)
	{
		
		
		JOptionPane.showMessageDialog(null, e.getMessage());
		return null;


	}


	}

	}



