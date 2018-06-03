package com.udc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.udc.domain.ZhangWu;
import com.udc.tools.JDBCUtils;

/*
 * implement CRUD for gjp_zhangwu table
 * dbutils toll, create QueryRunner
 */
public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	public void addZhangWu(ZhangWu zw) {
		String sql = "INSERT INTO gjp_zhangwu(flname, money, zhanghu, createtime, description)VALUES(?,?,?,?,?)";
		Object[] params = {zw.getFlname(), zw.getMoney(), zw.getZhanghu(), zw.getCreatetime(), zw.getDescription()};
		
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Update failed!");
		}
	}
	
	public List<ZhangWu> select(String startDate, String endDate){
		String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
		Object[] params = {startDate, endDate};
		
		try {
			@SuppressWarnings("deprecation")
			List<ZhangWu> list = (List<ZhangWu>) qr.query(sql, new BeanListHandler<>(ZhangWu.class), params);
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Query Failed");
		}
	}
	/*
	 * selectall called by service
	 * get records from db
	 */
	public List<ZhangWu> selectAll() {
		String sql = "SELECT * FROM gjp_zhangwu";
		// call method of qr
		try {
			List<ZhangWu> list = (List<ZhangWu>) qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Query Failed");
		}
	}

	public void editZhangWu(ZhangWu zw) {
		String sql = "Update gjp_zhangwu set flname=?, money=?, zhanghu=?, createtime=?, description=? WHERE zwid=?";
		Object[] params = {zw.getFlname(), zw.getMoney(), zw.getZhanghu(), zw.getCreatetime(), zw.getDescription(), zw.getZwid()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Update failed!");
		}
	}

	public void deleteZhangWu(ZhangWu zw) {
		String sql = "DELETE FROM gjp_zhangwu WHERE zwid=?";
		int zwid = zw.getZwid();
		try {
			qr.update(sql, zwid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Deleted Failed!");
		}
	}	
}
