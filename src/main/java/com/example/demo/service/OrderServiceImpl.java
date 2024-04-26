package com.example.demo.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import com.example.demo.model.Orders;
import com.example.demo.repo.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrdersRepository orderRepo;
	@Override
	public Orders saveOrder(Orders order) {
		Orders neworder=orderRepo.save(order);
		return neworder;
	}
	
	@Override
	public List<Orders> getListByOrders(Orders orders) {
		List<Orders>ordersAll=orderRepo.findAll();
		return ordersAll;
	}

	@Override
	public Orders getOrdersById(Integer order_id) {
		Orders orders=orderRepo.findById(order_id).get();
		return orders;
	}

	@Override
	public void deleteOrders(Integer order_id) {
		orderRepo.deleteById(order_id);
		
	}

	@Override
	public Orders updateOrders(Integer order_id, Orders ordersRequest) {
		Orders existingOrder=orderRepo.findById(order_id).get();
		existingOrder.setOrder_name(ordersRequest.getOrder_name());
		existingOrder.setOrder_price(ordersRequest.getOrder_price());
		return orderRepo.save(existingOrder);
		
	}

	@Override
	public Orders UpdateOrdersField(Integer order_id, Map<String, Object> fields) {
		Orders existingOrder=orderRepo.findById(order_id).get();
		
		fields.forEach((key,value)->{
		Field field=ReflectionUtils.findRequiredField(Orders.class, key);
		field.setAccessible(true);
		ReflectionUtils.setField(field, existingOrder, value);
		});
		
		return orderRepo.save(existingOrder);
	}
	
}
