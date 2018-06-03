package com.udc.controller;

import java.util.List;

import com.udc.domain.ZhangWu;
import com.udc.service.ZhangWuService;

/*
 * controller
 * receive data from view layer, pass them to service layer
 */
public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();
	
	
	public void addZhangWu(ZhangWu zw) {
		service.addZhangWu(zw);
	}
	/*
	 * search on condition: time period
	 */
	public List<ZhangWu> select(String startDate, String endDate){
		return service.select(startDate, endDate);
	}
	/*
	 * search all records
	 * called by viewer
	 * and call to service
	 */
	public List<ZhangWu> selectAll(){
		return service.selectAll();
	}
	
	
	public void editZhangWu(ZhangWu zw) {
		service.editZhangWu(zw);
	}
	public void deleteZhangWu(ZhangWu zw) {
		service.deleteZhangWu(zw);
	}
}
