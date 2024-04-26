package com.example.demo.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import com.example.demo.model.Item;
import com.example.demo.repo.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemrepo;

	@Override
	public Item getItemById(Integer item_id) {
		Item item=itemrepo.findById(item_id).get();
		return item;
	}

	@Override
	public Item saveItem(Item item) {
		
		return itemrepo.save(item);
	}

	@Override
	public void deleteItem(Integer item_id) {
		itemrepo.deleteById(item_id);
	}

	@Override
	public List<Item> getListByItem(Item item) {
		List<Item>itemAll=itemrepo.findAll();
		return itemAll;
	}

//	@Override
//	public List<Item> getListByItemName(String item_name) {
//		List<Item>itemAllName=itemrepo.findAll();
//		return itemAllName;
//	}

	@Override
	public Item updateItem(Integer item_id,Item itemRequest) {
		Item existingItem=itemrepo.findById(item_id).get();
		existingItem.setItem_name(itemRequest.getItem_name());
		existingItem.setItem_price(itemRequest.getItem_price());
		return itemrepo.save(existingItem);
	}

	@Override
	public Item UpdateItemField(Integer item_id, Map<String, Object> fields) {
		Item existingItem=itemrepo.findById(item_id).get();
		
		fields.forEach((key,value)->{
		Field field=ReflectionUtils.findRequiredField(Item.class, key);
		field.setAccessible(true);
		ReflectionUtils.setField(field, existingItem, value);
		});
		
		return itemrepo.save(existingItem);
	}

//	@Override
//	public List<Item> getAllItem(int pageNumber,String searchKey) {
//		Pageable pageable=(Pageable) PageRequest.of(pageNumber,12);
//		if(searchKey.equals("")) {
//			return (List<Item>)itemrepo.findAll(pageable);
//		}else {
//			
//			return (List<Item>)itemrepo.findByItem_nameContainingIgnoreCaseOrItem_categoryContainingIgnoreCase(searchKey, searchKey,pageable);
//		}
//		
//	}
}
