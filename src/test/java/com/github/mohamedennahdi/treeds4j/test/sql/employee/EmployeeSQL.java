package com.github.mohamedennahdi.treeds4j.test.sql.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.mohamedennahdi.treeds4j.tree.bean.SQLTreeBean;


public class EmployeeSQL extends SQLTreeBean<EmployeeSQL> {
	
	private final Logger logger = LogManager.getLogger(getClass());
	
	Integer id;
	String firstName;
	String lastName;
	Date birthDate;
	String gender;
	Date hireDate;
	Integer managerId;
	
	public EmployeeSQL() throws SQLException {
		super();
	}
	public EmployeeSQL(Connection connection) throws SQLException {
		super(connection);
	}
	
	public EmployeeSQL(ResultSet rs) throws SQLException {
		this.id = rs.getInt("emp_no");
		this.firstName = rs.getString("first_name");
		this.lastName = rs.getString("last_name");
		this.birthDate = rs.getDate("birth_date");
		this.hireDate = rs.getDate("hire_date");
		this.gender = rs.getString("gender");
		this.managerId = rs.getInt("manager_id");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	@Override
	public List<EmployeeSQL> getSubList() {
		List<EmployeeSQL> emps = new ArrayList<EmployeeSQL>();
		StringBuilder sql = new StringBuilder();
		sql.append("	SELECT	*	");
		sql.append("	FROM	EMPLOYEES	");
		sql.append("	WHERE	MANAGER_ID	").append("	=	").append("	?	");
		sql.append("	OR 	   (MANAGER_ID IS NULL AND ? IS NULL)	");
		
		try (PreparedStatement ps = getConnection().prepareStatement(sql.toString())){
			if (this.id == null) {
				ps.setNull(1, java.sql.Types.INTEGER);
				ps.setNull(2, java.sql.Types.INTEGER);
			} else {
				ps.setInt(1, this.id);
				ps.setInt(2, this.id);
			}
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					 emps.add(new EmployeeSQL(rs));
				}
			} catch (SQLException e) {
				logger.error("Resultset error", e);
			}
		} catch (SQLException e) {
			logger.error("PrparedStatement error", e);
		}
		
		return emps;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.firstName + " " + this.lastName + " " + this.managerId;
	}
}
