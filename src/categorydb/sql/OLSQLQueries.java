package categorydb.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OLSQLQueries {

	private Connection con;

	/* Creates a new MySQL querying object. Specific for only this Project */
	public OLSQLQueries(String host, String database, String user, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = null;
			con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, user, password);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			System.out.println("MySQL driver Exception");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/* Closes the Connection. */
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCategoryID(String[] split) throws NumberFormatException, SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO shopcategories VALUES(?,?,?)");
		ps.setInt(1, Integer.parseInt(split[0].trim()));
		ps.setString(2, split[1].trim());
		ps.setString(3, split[2].trim());
		ps.executeUpdate();
		
	}

}