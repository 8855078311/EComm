package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

//	@Query(value="select * from items i where item_name=?1", nativeQuery=true)
//	 List<Item>findByName(String item_name);

//	public List<Item> findAll(Pageable pageable);
//	public List<Item>findByItem_nameContainingIgnoreCaseOrItem_categoryContainingIgnoreCase(String key1,String key2,Pageable pageable);
	
}
