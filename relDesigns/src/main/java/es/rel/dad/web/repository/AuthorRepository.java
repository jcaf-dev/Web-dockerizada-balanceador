package es.rel.dad.web.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import es.rel.dad.web.entity.Author;

@CacheConfig(cacheNames = "itemsCache")
public interface AuthorRepository extends JpaRepository<Author,Long>{

	@CacheEvict(allEntries = true)
	Author save(Author autores);
	
	@Cacheable
	Author findByNameAuthor(String name);
	
	@Cacheable
	List<Author> findAll();

}
