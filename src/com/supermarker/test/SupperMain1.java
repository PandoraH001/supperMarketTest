package com.supermarker.test;

import java.util.Scanner;

public class SupperMain1 {
	
	public static void main(String[] args) {
		// 初始化超市在卖水果
		Suppermarkets.fruitsMap.put(1001, new Fruits(1001, "苹果", 8,0));
		Suppermarkets.fruitsMap.put(1002, new Fruits(1002, "草莓", 13,0));
		
		// 输入购买多少斤苹果
		Scanner scanner=new Scanner(System.in);
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

			System.out.println("是否继续：Y/N ？");
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
