package com.saikiran.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saikiran.dao.OrderRepo;
import com.saikiran.dao.ProductRepo;
import com.saikiran.model.Orders;
import com.saikiran.model.Products;
@Service
public class ProductAndOrderService {
	@Autowired
	private ProductRepo productrepo;
	
	@Autowired
	private OrderRepo orderrepo;

	public Products createProduct(Products product) {
		return productrepo.save(product);
	}

	public Iterable<Products> getProducts() {
		
		return productrepo.findAll();
	}

	public Orders createOrder(Orders order) {
		
		return orderrepo.save(order);
	}

	public Iterable<Orders> getOrders() {
		return orderrepo.findAll();
	}

	public Optional<Products> getproduct(Integer id) {
		return productrepo.findById(id);
		
	}

	public Optional<Orders> getOrder(Integer id) {
		return orderrepo.findById(id);

	}

	public int placeOrder(Integer id, Integer quantity, Orders order) {
		int result = 1;
		Products product = productrepo.findById(id).orElse(new Products());
		if(product == null)
			return result;
		order.setQuantity(quantity);
		
		order.setProducts(product);
		orderrepo.save(order);
		result = 0;
		return result;
	}

	public int updateOrder(Integer id, Integer quantity) {
	int result = 1;
		Orders order = orderrepo.findById(id).orElse(new Orders());
		if(order.getOrderId() == 0) {
			return result;
		}
		
		order.setQuantity(quantity);
		orderrepo.save(order); 
		result = 0;
		
		return result;
	}
}
