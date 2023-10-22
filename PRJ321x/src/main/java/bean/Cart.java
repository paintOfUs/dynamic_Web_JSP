package bean;
import java.util.ArrayList;
import java.util.List;

import bean.Products;
public class Cart {
	private ArrayList<Products> items;
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	public void add(Products it) {
		for(Products x : items) {
			if(x.getProductId() == it.getProductId()) {
				x.setNum(x.getNum()+1);	
				return;
			}
		}
		it.setNum(1);
		items.add(it);
		
	}
	
	public void remove(int id) {
		for(Products x : items) {
			if(x.getProductId() == id) {
				items.remove(x);
				return;
			}
		}
	}
	
	public double getAmount() {
		double price = 0;
		for(Products x : items) {
			price += x.getPrice() * x.getNum();
		}
		return Math.round(price*100)/100;
	}
	
	public double getSize() {
		return items.size();
	}
	
	public Products getProduct(int i) {
		for (Products x : items) {
			if(x.getProductId()==i) {
				return x;
			}
		}
		return null;
	}
	
	public ArrayList<Products> getItems(){
		return items;
	}
}
