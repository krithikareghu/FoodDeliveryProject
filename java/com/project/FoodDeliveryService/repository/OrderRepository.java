package com.project.FoodDeliveryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FoodDeliveryService.Model.OrderData;

@Repository
public interface OrderRepository extends JpaRepository<OrderData, Long> {

//	OrderData findByitemname(String itemname);

	boolean existsByitemname(String itemname);

}
