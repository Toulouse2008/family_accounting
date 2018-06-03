package com.udc.tools;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * obtain tools to connect to database
 * implement dbcp-connection pool
 */
public class JDBCUtils {
	private static BasicDataSource datasource = new BasicDataSource();
	
	// static block, load data
	static {
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/gjp");
		datasource.setUsername("root");
		datasource.setPassword("2011");
		datasource.setMaxActive(10);
		datasource.setMaxIdle(5);
		datasource.setMinIdle(2);
		datasource.setInitialSize(10);
	}
	public static DataSource getDataSource() {
		return datasource;
	}
	
}
