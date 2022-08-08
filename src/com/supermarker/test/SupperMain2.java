package com.supermarker.test;

import java.util.Scanner;

public class SupperMain2 {
	
	public static void main(String[] args) {
		// 初始化超市在卖水果
		Suppermarkets.fruitsMap.put(1001, new Fruits(1001, "苹果", 8,0));
		Suppermarkets.fruitsMap.put(1002, new Fruits(1002, "草莓", 13,0));
		boolean addFlag=true;
		Scanner scanner=new Scanner(System.in);
		
		// 输入需要增加的水果
		while (addFlag) {
			System.out.println("请输入需要增加的水果：");
			String fruitName=scanner.nextLine();
			
			Fruits fruits=Suppermarkets.getFruit(fruitName);
			if (fruits != null) {
				System.out.println("已存在，请重新输入需要增加的水果：");
				fruitName=scanner.nextLine();
				continue;
			}
			System.out.println("请输入需要增加水果的价格：");
			double price=scanner.nextDouble();
			
			Suppermarkets.addFruit(fruitName, price);
			System.out.println("==new map===="+Suppermarkets.fruitsMap.size());
			
			System.out.println("需要继续增加水果吗？Y/N");
			String str=scanner.next();
			if ("Y".equals(str)) {
				scanner.nextLine();
				continue;
			}
			break;
		}
		
		// 输入购买多少斤苹果
		boolean flag=true;
		while (flag) {
			String fruitName=null;
			Fruits fruits=null;
			while (flag) {
				System.out.println("请输入需要购买的水果：");
				fruitName=scanner.nextLine();
				// 查询并获取对应水果的属性
				fruits=Suppermarkets.getFruit(fruitName);
				if (fruits != null) {
					break;
				}
			}			
			
			System.out.println("请输入需要购买的重量：");
			double weight=scanner.nextDouble();
			
			// set 水果的重量
			fruits.setWeight(weight);
			Suppermarkets.orderMap.put(fruits.getId(), fruits);

			System.out.println("是否继续购买：Y/N ？");
			String str=scanner.next();
			
			if ( !"Y".equals(str) ) {
				System.out.println("输入结束：");
				scanner.close();
				double total=Suppermarkets.totalAmount(Suppermarkets.orderMap);
				System.out.println("结算总金额为："+total);
				break;
			}
			System.out.println("继续输入：");
			scanner.nextLine();
		}
		
	}
}
