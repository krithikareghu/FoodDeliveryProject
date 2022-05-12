package com.project.FoodDeliveryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
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

	//Categorydata findbycategorydatas(Categorydata categorydata);


	//ItemsData findOne(Long restaurantid);

}
