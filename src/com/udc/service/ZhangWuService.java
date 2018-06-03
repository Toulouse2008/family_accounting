package com.udc.service;
/*
 * service layer
 * accept data from controller, call dao layer to complete operations on database
 */

import java.util.List;

import com.udc.dao.ZhangWuDao;
import com.udc.domain.ZhangWu;

public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	
	public void addZhangWu(ZhangWu zw) {
		dao.addZhangWu(zw);
	}
	
	public List<ZhangWu> select(String startDate, String endDate){
		return dao.select(startDate, endDate);
	}
	/*
	 * search all records
	 * called by controller
	 * call to DAO
	 */
	public List<ZhangWu> selectAll() {
		return dao.selectAll();
	}

	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}

	public void deleteZhangWu(ZhangWu zw) {
		dao.deleteZhangWu(zw);
	}
}
 