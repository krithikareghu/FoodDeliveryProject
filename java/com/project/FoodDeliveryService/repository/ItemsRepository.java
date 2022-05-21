package com.project.FoodDeliveryService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.FoodDeliveryService.Model.Categorydata;
import com.project.FoodDeliveryService.Model.ItemsData;
@Repository
public interface ItemsRepository  extends JpaRepository<ItemsData, Long> {
	
	ItemsData findByItemname(String itemname);

	boolean existsByitemname(String itemname);

	ItemsData findAllByID(Long restaurantid);

	boolean existsByitempicture(String itempicture);

	void save(Categorydata categorydata);
	
	
//	@Query("Select item FROM ItemsData item WHERE item.category_ID=:cat_id")
//	List<ItemsData> getByCategoryId(@Param("cat_id")String cat_id);
	@Query("Select itempicture from ItemsData")
	List<byte[]>finditempictures();

	//Categorydata findbycategorydatas(Categorydata categorydata);


	//ItemsData findOne(Long restaurantid);

}
