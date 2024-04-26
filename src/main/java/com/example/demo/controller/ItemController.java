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

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemservice;
	////•GET @Path: Retrieve a specific item by ID.
	//http://localhost:8082/api/items/1
	@GetMapping("/api/items/{item_id}")
	public ResponseEntity<Item>getItemById(@PathVariable("item_id") Integer item_id){
		Item item=itemservice.getItemById(item_id);
		return ResponseEntity.ok().body(item);
		
	}
	//http://localhost:8082/api/items
	@PostMapping("/api/items")
	public ResponseEntity<Item>saveItem(@RequestBody Item item){
		Item itemnew=itemservice.saveItem(item);
		return ResponseEntity.ok().body(itemnew);
		
	}
	//http://localhost:8082/api/items/3
	@DeleteMapping("/api/items/{item_id}")
	public void deleteEmloyeeById(@PathVariable("item_id")Integer item_id) throws Exception {
		itemservice.deleteItem(item_id);
	}
	////•GET /api/items: Retrieve all items.
	//http://localhost:8082/api/getitems
	@GetMapping("/api/getitems")
	public ResponseEntity<List<Item>> getListByItem(Item item) {
		List<Item>itemAll=itemservice.getListByItem(item);
		return ResponseEntity.ok().body(itemAll);
		
	}
	//Get ByName
//	@GetMapping("/api/items/{item_name}")
//	public ResponseEntity<List<Item>>getListByItemName(@PathVariable("item_name") String item_name)
//	{
//		List<Item>item=itemservice.getListByItemName(item_name);
//		return ResponseEntity.ok().body(item);
//		
//	}
	
	//http://localhost:8082/api/items/1
	@PutMapping("/api/items/{item_id}")
	public Item updateItem(@PathVariable("item_id")Integer item_id,@RequestBody Item itemRequest) {
		
		return itemservice.updateItem(item_id, itemRequest);
		
	}
	//http://localhost:8082/api/items/1
	@PatchMapping("/api/items/{item_id}")
	public Item UpdateItemField(@PathVariable("item_id")Integer item_id,@RequestBody Map<String,Object>Fields) {
		return itemservice.UpdateItemField(item_id, Fields);	
	}
	
//	@GetMapping("/api/items/getAllItems")
//	public List<Item>getAllItem(@RequestParam(defaultValue="0") int pageNumber,@RequestParam(defaultValue="") String searchKey){
//		
//		List<Item>result=itemservice.getAllItem(pageNumber, searchKey);
//		System.out.println("Result size is"+result.size());
//		return result;
//		
//	}
	
	
}
