package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Orders;
import com.example.demo.service.OrderService;


@RestController
public class OrdersController {
	@Autowired 
	private OrderService orderService;
	//http://localhost:8082/api/orders
	@PostMapping("/api/orders")
	public ResponseEntity<Orders>saveItem(@RequestBody Orders orders){
		Orders neworder=orderService.saveOrder(orders);
		return ResponseEntity.ok().body(neworder);
		
	}
	//http://localhost:8082/api/orders/1
	@GetMapping("/api/orders/{order_id}")
	public ResponseEntity<Orders>getOrdersById(@PathVariable("order_id") Integer order_id){
		Orders orders=orderService.getOrdersById(order_id);
		return ResponseEntity.ok().body(orders);
		
	}
	@GetMapping("/api/orders")
	public ResponseEntity<List<Orders>> getListByOrders(Orders orders) {
		List<Orders>OrdersAll=orderService.getListByOrders(orders);
		return ResponseEntity.ok().body(OrdersAll);
		
	}
	@PutMapping("/api/orders/{order_id}")
	public Orders updateOrders(@PathVariable("order_id")Integer order_id,@RequestBody Orders ordersRequest) {
		
		return orderService.updateOrders(order_id, ordersRequest);
		
	}
	@PatchMapping("/api/orders/{order_id}")
	public Orders UpdateOrdersField(@PathVariable("order_id")Integer order_id,@RequestBody Map<String,Object>Fields) {
		return orderService.UpdateOrdersField(order_id, Fields);	
	}
	@DeleteMapping("/api/orders/{order_id}")
	public void deleteOrders(@PathVariable("order_id") Integer order_id)throws Exception{
		orderService.deleteOrders(order_id);
	}
}