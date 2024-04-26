package com.example.demo.service;

import java.util.List;
import java.util.Map;
import com.example.demo.model.Orders;

public interface OrderService {
	// Create a new order.
	public Orders saveOrder(Orders order);
	
	public List<Orders>getListByOrders(Orders orders);
	
	public Orders getOrdersById(Integer order_id);
	
	
	public Orders updateOrders(Integer order_id, Orders ordersRequest);
	
	public Orders UpdateOrdersField(Integer order_id, Map<String,Object>fields);
	
	public void deleteOrders(Integer order_id);
	
	
}
