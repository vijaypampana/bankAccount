package main.java.com.vijay.web.javaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class LoginDAO {
	
	private DataSource dataSource;
    
    public DataSource getDataSource() {
    	return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
    
    public boolean selectDAO(String username, String password) {
    	
    	String selectStmt = "Select count(*) from testdb.logindetail where username=? and password=?";
    	Connection conn = null;
    	boolean success = false;
    	try {
    		conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(selectStmt);
			ps.setString(1, username);			
			ps.setString(2, password);
			ResultSet test = ps.executeQuery();
			if(test.next()) {
				if(!test.getString(1).equalsIgnoreCase("0")) {
					System.out.println("Login Details are verified successfully");
					success = true;
				} else {
					System.out.println("DATA not found in the SQL Database");
				}
				
			}
			
			ps.close();

		} catch (SQLException e) {
			//System.out.println("Inside Exception Loop");
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
				}
			}
		}
    	//System.out.println(success);
    	return success;
    }
    	
    
    
    public void insert(Login login) {
    	
    	String selectStmt = "Select * from logindetail where username=? and password=?";
    	Connection conn = null;
    	try {
    		conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(selectStmt);
			ps.setString(1, login.getUsername());			
			ps.setString(2, login.getPassword());
			ps.executeQuery();
			ps.close();
			System.out.println("Login Details are verified successfully");

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
/*
		String sql = "INSERT INTO applicant "
				+ "( applfirstname, applmidname,  "
				+ "aprline2,  city,state, zipCode)"
				+ "VALUES ( ?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, applications.getApplfirstname());			
			ps.setString(8, applications.getZipcode());
			ps.executeUpdate();
			ps.close();
			System.out.println("Applicants data updated successfully!");

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
*/	}




}
