package es.rel.dad.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.rel.dad.web.entity.Orders;


public interface OrdersRepository extends JpaRepository<Orders,Long>{
	//List<Order> findByNameOrder(int number);
}
