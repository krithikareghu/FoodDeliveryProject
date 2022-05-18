package com.project.FoodDeliveryService.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.FoodDeliveryService.Model.CartData;

@Repository
public interface CartRepository extends JpaRepository<CartData, Long> {
//	@Query("update CartData cart set cart.quantity=cart.quantity+1 where cart.id=:id")
	
//	@Query("select * from CartData cart")
//	void updatequantity(Long id);
//	
	
//	@Query("from CartData where ID=?1")
//    CartData findByid(Long id);
	
	
	@Query("Select sum(addCart.price) FROM CartData addCart WHERE addCart.user_ID=:user_ID")
	double getTotalAmountByUserId(@Param("user_ID")Long user_ID);
	@Query("Select addCart  FROM CartData addCart WHERE addCart.user_ID=:user_ID")
	List<CartData> getCartByuserId(@Param("user_ID")Long user_ID);
	@Query("Select addCart  FROM CartData addCart ")
	Optional<CartData> getCartByuserIdtest();
	@Query("Select addCart  FROM CartData addCart WHERE addCart.itemsData.ID= :itemsData_ID and addCart.user_ID=:user_ID")
	Optional<CartData> getCartByitemIdAnduserId(@Param("user_ID")Long user_id,@Param("itemsData_ID")Long itemsData_ID);
	@Modifying
    @Transactional
	@Query("DELETE  FROM CartData addCart WHERE addCart.ID =:cart_ID   and addCart.user_ID=:user_ID")
	void deleteCartByIdAndUserId(@Param("user_ID")Long user_ID,@Param("cart_ID")Long cart_ID);
	@Modifying
    @Transactional
	@Query("DELETE  FROM CartData addCart WHERE   addCart.user_ID=:user_ID")
	void deleteAllCartByUserId(@Param("user_ID")Long user_ID);
	
	@Modifying
    @Transactional
	@Query("DELETE  FROM CartData addCart WHERE addCart.user_ID=:user_ID")
	void deleteAllCartUserId(@Param("user_ID")Long user_ID);
	@Modifying
    @Transactional
	@Query("update CartData addCart set addCart.qty=:qty,addCart.price=:price WHERE addCart.id=:cart_ID")
	void updateQtyByCartId(@Param("cart_ID")Long cart_ID,@Param("price")double price,
			@Param("qty")Integer qty);
}
