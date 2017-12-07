package com.denlaku.j2ee.jdbc;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class MysqlUtilTest {

	@Test
	public void test() {
		Connection connection = MysqlUtil.getConnection();
		PreparedStatement prepareStatement;
		try {
			prepareStatement = connection.prepareStatement("select * from t_user");
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				String empno = resultSet.getString("uname");
				Date date = resultSet.getDate("create_date");
				System.out.println("empno====: " + empno);
				System.out.println("date====: " + date);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
