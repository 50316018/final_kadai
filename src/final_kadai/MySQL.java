package final_kadai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	String driver;
	String server,dbname,url,user,password;
    Connection con;
    Statement stmt;
    ResultSet rs;
	
	public MySQL() {
		this.driver = "org.gjt.mm.mysql.Driver";
		this.server = "j11000.sangi01.net";  
		this.dbname =  "50316018";
		this.url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";
		this.user = "50316018";  
		this.password = "50316018"; 
		try {
			this.con =  DriverManager.getConnection(url, user, password);
			this.stmt = con.createStatement ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(){
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet selectAll(){
		String sql = "SELECT * FROM the_price_of_gasoline";
		ResultSet rs = null;
		try{
			rs = stmt.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
}
