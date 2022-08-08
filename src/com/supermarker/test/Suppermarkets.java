package com.supermarker.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Suppermarkets {
	private double discount;
	private int fullReduce;

    public static Map<Integer, Fruits> fruitsMap=new HashMap<Integer, Fruits>();
    public static Map<Integer, Fruits> orderMap=new HashMap<Integer, Fruits>();
	
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getFullReduce() {
		return fullReduce;
	}
	public void setFullReduce(int fullReduce) {
		this.fullReduce = fullReduce;
	}
	/**
	 *  结算方式打折
	 *  8 折促销
	 */			
	public double discountSalesPromotion(){
		return this.discount;
	}
	/**
	 *  结算方式满减
	 *  满100 减 10
	 */
	public int fullReductionSalesPromotion(){
		return this.fullReduce;
	}
	/**
	 *  添加水果
	 *  
	 */
	public static  void addFruit(String fruitName,double price){
		int key =1000+fruitsMap.size()+1;
		Suppermarkets.fruitsMap.put(key, new Fruits(key, fruitName, price,0));
		
	}
	/**
	 *  结算总计金额
	 *  
	 */
	public static double totalAmount(Map<Integer, Fruits> map){
		double sum=0;
		if (map !=null ) {
			Set<Integer> keySet=map.keySet();
			for (Integer key : keySet) {
				sum=sum+map.get(key).getPrice()*map.get(key).getWeight();
			}
		}
		return sum;
	}
	
	public static Fruits getFruit(String fruitName){
		// 查询并获取对应水果的价格
		Set<Integer> keySet=fruitsMap.keySet();
		for (Integer key : keySet) {
		   if ((fruitName != null || fruitName != "") && fruitName.equals(fruitsMap.get(key).getFruit())) {
				return fruitsMap.get(key);
			}
		}
		return null;
	}
  
	public static void main(String[] args) {
		// 初始化超市在卖水果
		fruitsMap.put(1001, new Fruits(1001, "苹果", 8,0));
		fruitsMap.put(1002, new Fruits(1002, "草莓", 13,0));
		
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
				fruits=getFruit(fruitName);
				if (fruits != null) {
					break;
				}
			}			
			
			System.out.println("请输入需要购买的重量：");
			double weight=scanner.nextDouble();
			
			// set 水果的重量
			fruits.setWeight(weight);
			orderMap.put(fruits.getId(), fruits);

			System.out.println("是否继续：Y/N ？");
			String str=scanner.next();
			
			if ( !"Y".equals(str) ) {
				System.out.println("输入结束：");
				scanner.close();
				double total=totalAmount(orderMap);
				System.out.println("结算总金额为："+total);
				break;
			}
			System.out.println("继续输入：");
			scanner.nextLine();
		}
		
	}
}
