package es.rel.dad.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import es.rel.dad.web.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{
		
	Client findByNameAndPassword(String name, String password);	
	
	Optional<Client> findByName(String Name);
	
	List<Client> findAll();

}
