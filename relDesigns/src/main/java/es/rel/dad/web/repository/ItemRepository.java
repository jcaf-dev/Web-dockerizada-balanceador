package es.rel.dad.web.repository;


import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import es.rel.dad.web.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Long>{

	Item save(Item items);
	
	List<Item> findAll();
	
	Item findByNameItem(String name);
}
