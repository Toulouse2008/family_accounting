package com.udc.domain;

public class ZhangWu {
	private Integer zwid;
	private String flname;
	private Double money;
	private String zhanghu;
	private String createtime;
	private String description;
	
	public ZhangWu() {
		
	}
	
	public ZhangWu(String flname, Double money, String zhanghu, String createtime, String description) {
		super();
		this.flname = flname;
		this.money = money;
		this.zhanghu = zhanghu;
		this.createtime = createtime;
		this.description = description;
	}
	
	public ZhangWu(Integer zwid, String flname, Double money, String zhanghu, String createtime, String description) {
		super();
		this.zwid = zwid;
		this.flname = flname;
		this.money = money;
		this.zhanghu = zhanghu;
		this.createtime = createtime;
		this.description = description;
	}
	public ZhangWu(int zwid) {
		this.zwid = zwid;
	}

	public Integer getZwid() {
		return zwid;
	}
	public void setZwid(Integer zwid) {
		this.zwid = zwid;
	}
	public String getFlname() {
		return flname;
	}
	public void setFlname(String flname) {
		this.flname = flname;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getZhanghu() {
		return zhanghu;
	}
	public void setZhanghu(String zhanghu) {
		this.zhanghu = zhanghu;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ZhangWu [zwid=" + zwid + ", flname=" + flname + ", money=" + money + ", zhanghu=" + zhanghu
				+ ", createtime=" + createtime + ", description=" + description + "]";
	}
}
