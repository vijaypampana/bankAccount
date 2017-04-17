package main.java.com.vijay.web.javaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

public class IncomeDAO {
	
	private DataSource dataSource;
    
    public DataSource getDataSource() {
    	return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
    
    public boolean insert(Income incomes) {
    	
    	boolean success = false;
    	
		String sql = "INSERT INTO testdb.income "
				+ "( ssn, incomemode, annual,  housemode, rent) "
				+ "VALUES ( ?, ?, ?, ?, ? )";
		Connection conn = null;
		

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, incomes.getApplSSN());	
			ps.setString(2, incomes.getIncomemode());
			ps.setString(3, incomes.getApplincome());
			ps.setString(4, incomes.getRentorOwn());
			ps.setString(5, incomes.getRentorleaseamt());
			ps.executeUpdate();
			ps.close();
			System.out.println("Applicants data updated successfully!");
			success = true;

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
		
		return success;
	}

}
