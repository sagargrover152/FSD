package com.ibm.takehome.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.takehome.bean.Products;
import com.ibm.takehome.dao.DaoClass;

@Service
public class ServiceClass {
	@Autowired
	DaoClass dao;
	
	public boolean checkId(int productId) {
		return dao.checkId(productId);
	}

	public int calculate(int total, int productId, int quantity) {
		if(dao.delFromDb(productId,quantity))
		{
			int price = dao.getPrice(productId);
			total = total+(quantity*price);
			return total;
		}
		else
		{
			return total;
		}
	}

	public ArrayList<Products> store(int productId, int quantity, ArrayList<Products> arr) {
		
		
		Products prod = dao.fetchInfo(productId,quantity);
		prod.setProductQuantity(quantity);
		arr.add(prod);
		return arr;
	}
	
}
