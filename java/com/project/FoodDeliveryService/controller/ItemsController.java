package com.project.FoodDeliveryService.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.ItemDataDto;
import com.project.FoodDeliveryService.Service.ItemsDetailsService;
import com.project.FoodDeliveryService.repository.ItemsRepository;



@RestController
@CrossOrigin("http://localhost:4200")
public class ItemsController {
	
	@Autowired
	ItemsRepository itemrepo;
	
	@Autowired
	private ItemsDetailsService itemsdetails;
	
	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public ResponseEntity<?> saveitem(@RequestBody ItemDataDto item) throws Exception {

		if (this.itemrepo.existsByitemname(item.getItemname()))
		  return ResponseEntity
				.badRequest()
				.body("Error: item is already included!");
		else
			itemsdetails.save(item);

		return ResponseEntity.ok(item);
	}
}
