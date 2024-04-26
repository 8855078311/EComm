package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.model.Item;

public interface ItemService {
	public List<Item>getListByItem(Item item);
	
//	public List<Item> getListByItemName(String item_name);

	public Item getItemById(Integer item_id);
	
	public Item saveItem(Item item);
	
	public void deleteItem(Integer item_id);
	
	public Item updateItem(Integer item_id, Item itemRequest);
	
	public Item UpdateItemField(Integer item_id, Map<String,Object>fields);
	
//	//search 
//	public List<Item>getAllItem(int pageNumber,String searchKey);
	
}
