package com.supermarker.test;


public class Fruits {
	   private int id;
       private String fruit;
       private double price;
       private double weight;
              
	public Fruits(int id,String fruitType,double price,double weight){
    	   this.id=id;
    	   this.fruit=fruitType;
    	   this.price=price;
    	   this.setWeight(weight);
       }
       
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFruit() {
		return fruit;
	}
	public void setFruitType(String fruit) {
		this.fruit = fruit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
