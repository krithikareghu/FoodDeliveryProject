package com.project.FoodDeliveryService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.FoodDeliveryService.Model.Checkout_Cart;

@Repository
public interface CheckOutRepository extends JpaRepository<Checkout_Cart, Long> {
	
	@Query("Select checkCart  FROM Checkout_Cart checkCart WHERE checkCart.user_ID=:user_ID")
	List<Checkout_Cart> getByuserId(@Param("user_ID")Long user_ID);

}
