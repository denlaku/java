package com.denlaku.j2ee.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class OracleUtilTest {

	@Test
	public void test01() {
		Connection connection = OracleUtil.getConnection();
		PreparedStatement prepareStatement;
		try {
			prepareStatement = connection.prepareStatement("select * from emp");
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				String empno = resultSet.getString("empno");
				System.out.println("empno====: " + empno);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
