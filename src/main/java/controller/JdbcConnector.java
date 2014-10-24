package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class JdbcConnector {

	private String className = "com.mysql.jdbc.Driver";
	private String server = "localhost";	// default values
	private String port = "3306";	
	private String dbName = "testdb"; 

	public JdbcConnector() {}
	
	public JdbcConnector(String server, String port, String dbName) {
		this.server = server;
		this.port = port;
		this.dbName = dbName;
	}
	
//	public static void main(String[] args) {
//		JdbcConnector connector = new JdbcConnector();
//		Connection conn = connector.getDBConnection("admin", "admin");
//		try {
//			connector.writeMetaData(connector.executeSelect(conn, "select * from users"));
//
////			connector.insertIntoUsersTable(conn, "test1", "test1", 2);
//			
//			// close the connection
//			conn.close();
//	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * return a database connection with the login information
	 * @param username
	 * @param password
	 * @return
	 */
	public Connection getDBConnection(String username, String password) {
		Connection conn = null;
		try {
			Class.forName(className).newInstance();

			String connectionURL = "jdbc:mysql://" + server + ":" + port + "/" + dbName;
			conn = DriverManager.getConnection(connectionURL, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * execute select query. Ex. "select * from users"
	 * 
	 * @param conn
	 * @param selectQuery
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeSelect(Connection conn, String selectQuery) throws SQLException {
		Statement statement = (Statement) conn.createStatement();
		// resultSet gets the result of the SQL query
		ResultSet resultSet = statement.executeQuery(selectQuery);
		System.out.println(selectQuery);
		return resultSet;
	}

	/**
	 * insert a new row into Users table, automatically add creation timestamp
	 * 
	 * @param conn
	 * @param username
	 * @param password
	 * @param userTypeId
	 * @throws SQLException
	 */
	public void insertIntoUsersTable(Connection conn, String username, String password, int userTypeId, int customerId, long currentUserId, Timestamp timestamp, String timezone, boolean enabled) throws SQLException {
		
		String insertStmt = this.geneInsertStmt("users", "username", "password", "user_type_id", "customer_id", "created_by", "creation_time", "enabled"); 
		PreparedStatement preparedStatement = conn.prepareStatement(insertStmt);
		
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		preparedStatement.setInt(3, userTypeId); 
		preparedStatement.setInt(4, customerId);
		preparedStatement.setLong(5, currentUserId);
		 
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(timezone));
		preparedStatement.setTimestamp(6, timestamp, cal); //TODO define calendar for current Time Zone
		
		preparedStatement.setBoolean(7, enabled);
		System.out.println(preparedStatement); 
		
		preparedStatement.executeUpdate();
	}

	/**
	 * add a new customer into Customers table, with customer_id auto-incremented
	 * @param conn
	 * @param custName
	 * @param ipAddress
	 * @param description (could be null)
	 * @throws SQLException 
	 */
	public void insertIntoCustomersTable(Connection conn, String custName, String ipAddress, String description) throws SQLException {
		String insertStmt = this.geneInsertStmt("customers", "customer_name", "ip_address", "description");
		PreparedStatement preparedStatement = conn.prepareStatement(insertStmt);
		
		preparedStatement.setString(1, custName);
		preparedStatement.setString(2, ipAddress);
		preparedStatement.setString(3, description); 
		System.out.println(preparedStatement);
		
		preparedStatement.executeUpdate();
	}
	
	/**
	 * add a new site into Sites table for the given customer, with site_id auto-incremented
	 * @param conn
	 * @param siteName
	 * @param customerId
	 * @throws SQLException
	 */
	public void insertIntoSitesTable(Connection conn, String siteName, int customerId) throws SQLException {
		//TODO open_time, close_time, emergency_state
		String insertStmt = this.geneInsertStmt("sites", "site_name", "customer_id");
		PreparedStatement preparedStatement = conn.prepareStatement(insertStmt);
		
		preparedStatement.setString(1, siteName);
		preparedStatement.setInt(2, customerId);
		System.out.println(preparedStatement);
		
		preparedStatement.executeUpdate();
	}
	
	
	private void writeMetaData(ResultSet resultSet) throws SQLException {
		// now get some metadata from the database
		System.out.println("The columns in the table are: ");
		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
		}
	}

	/**
	 * Generate an Insert SQL statement in the form of PrepraredStatement final
	 * form: INSERT INTO table (attr0, attr1, .., attrN) VALUES (?, ?, .., ?)"
	 * 
	 * @param table
	 * @param attributes
	 * @return
	 */
	public String geneInsertStmt(String table, String... attributes) {
		String sql = "INSERT INTO " + table + " (" + attributes[0]; // OR
																	// REPLACE
		int length = attributes.length; // number of columns
		for (int i = 1; i < length; i++) {
			sql += ", " + attributes[i];
		}
		sql += ") VALUES (?"; // except the first column
		for (int i = 1; i < length; i++) {
			sql += ", ?";
		}
		sql += ")";
		// System.out.println(sql);
		return sql;
	}
}
