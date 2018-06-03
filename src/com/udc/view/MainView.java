package com.udc.view;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.udc.controller.ZhangWuController;
import com.udc.domain.ZhangWu;

/*
 * view layer
 * display what user will see and the place to interact with user
 */
public class MainView {
	private ZhangWuController controller = new ZhangWuController();

	/*
	 * implement view accept input display the output
	 */
	public void run() {
		/*
		 * 1. Print menu 2. Get input 3. call specific method
		 */
		boolean flag = true;
		Scanner in = new Scanner(System.in);
		while (flag) {
			System.out.println("---------------Welcome to Family Accounting System---------------");
			System.out.println("1. Add An Item　2. Edit An Item　3.Delete An Item　4. Search Items　5. Quit");
			System.out.println("Please input your action [1-5]:");
			int choice = in.nextInt();
			switch (choice) {
				case 1:
					addZhangWu();					
					break;
				case 2:
					//editZhangWu();
					editZhangWu();
					break;
				case 3:
					//deleteZhangWu();
					deleteZhangWu();
					break;
				case 4:
					selectZhangWu();
					break;
				case 5:
					System.out.println("Bye ~");
					flag = false;
					System.exit(0);
					break;
			default:
				System.out.println("Please correct you input!");
			}
		}
	}

	private void deleteZhangWu() {
		Scanner sc = new Scanner(System.in);
		selectAll();
		System.out.print("Enter the record number to be editted:");
		int zwid = sc.nextInt();
		ZhangWu zw = new ZhangWu(zwid);
		
		controller.deleteZhangWu(zw);
	}

	// edit method
	private void editZhangWu() {
		Scanner sc = new Scanner(System.in);
		selectAll();
		System.out.print("Enter the record number to be editted:");
		int zwid = sc.nextInt();
		System.out.print("Which class:");
		String flname = sc.nextLine();
		System.out.print("Input account:");
		String zhanghu = sc.nextLine();
		System.out.print("Input amount");
		Double money = sc.nextDouble();						
		System.out.print("Input date:");
		String createtime = sc.next();
		
		System.out.println("Input description:");
		String description = sc.next();
		// encapulate data in zhangwu 
		ZhangWu zw = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		controller.editZhangWu(zw);
		System.out.println("Record id: " + zwid + "Edit success");
	}

	private void addZhangWu() {
		System.out.println("Input the following items:");
		Scanner sc = new Scanner(System.in);				
		System.out.print("Which class:");
		String flname = sc.nextLine();
		System.out.print("Input account:");
		String zhanghu = sc.nextLine();
		System.out.print("Input amount");
		Double money = sc.nextDouble();						
		System.out.print("Input date:");
		String createtime = sc.next();
		
		System.out.println("Input description:");
		String description = sc.next();
		ZhangWu zw = new ZhangWu(flname, money, zhanghu, createtime, description);
		controller.addZhangWu(zw);
		System.out.println("Success!");
	}

	/*
	 * selectZhangWu()
	 * display query method
	 */
	public void selectZhangWu() {
		System.out.println("1. All   2. Condition");
		Scanner sc = new Scanner(System.in);
		
		int selection = sc.nextInt();
		switch(selection){
			case 1:
				selectAll();
				break;
			case 2:
				select();
				break;
			default:
				System.out.println("Wrong input!");
		}
	}

	
	// search all record
	private void selectAll() {
		List<ZhangWu> list = controller.selectAll();
		if(list.size() != 0)
			printZhangWu(list);		
		else
			System.out.println("No records find");		
	}	
	
	/*
	 * query certain time period
	 */
	private void select() {
		System.out.println("Date format: YYYY-MM-DD");
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the start date:");
		String startDate = sc.nextLine();
		System.out.print("Please enter the end date:");
		String endDate = sc.nextLine();
		List<ZhangWu> list = controller.select(startDate, endDate);
		if(list.size() != 0)
			printZhangWu(list);		
		else
			System.out.println("No records find");
	}
	
	// print zhangwu list
	private void printZhangWu(List<ZhangWu> list) {
		System.out.println("ID\t\tclass\t\taccount\t\tamount\t\tdate\t\tcomments");
		for(ZhangWu zw : list) {
			System.out.println(
					zw.getZwid() + "\t\t" + zw.getFlname() + "\t\t" + zw.getZhanghu() +
					"\t\t" + zw.getMoney() + "\t\t" + zw.getCreatetime() + "\t\t" + zw.getDescription());
		}
	}
}
