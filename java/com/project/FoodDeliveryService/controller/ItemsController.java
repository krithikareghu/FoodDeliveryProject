package com.project.FoodDeliveryService.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.FoodDeliveryService.Model.Categorydata;
import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Service.ItemsDetailsService;
import com.project.FoodDeliveryService.dto.ItemDataDto;
import com.project.FoodDeliveryService.repository.CategoryRepository;
import com.project.FoodDeliveryService.repository.ItemsRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class ItemsController {

	@Autowired
	ItemsRepository itemrepo;

	@Autowired
	private ItemsDetailsService itemsdetails;

	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public ResponseEntity<?> saveitem(@RequestParam("myFile") MultipartFile file, @RequestParam String itemname,
			@RequestParam String itemprice, @RequestParam String categoryname) throws Exception {

		if (this.itemrepo.existsByitemname(itemname)) {

			return ResponseEntity.badRequest().body("Error: item is already included!");
		} else {

			ItemsData itemsData = new ItemsData();
			itemsData.setItemname(itemname);
			itemsData.setItemprice(itemprice);
			itemsData.setItempicture(file.getBytes());

			Categorydata categorydata = categoryRepository.findBycategoryname(categoryname);

			Set<Categorydata> categorydatas = new HashSet<Categorydata>();

			categorydatas.add(categorydata);
			itemsData.category_items(categorydata);

			final ItemsData newitemData = itemrepo.save(itemsData);
			return ResponseEntity.ok(newitemData);
		}

	}

	@GetMapping("/getitem")
	public Set<ItemsData> getitem(@RequestBody String categoryname) {

		ItemsData itemsData = new ItemsData();
		Categorydata categorydata = categoryRepository.findBycategoryname(categoryname);
		Set<ItemsData> category_ItemsData = categorydata.getCategory_ItemsDatas();

		return null;

	}
}

//	@RequestMapping(value = "/addpicture", method = RequestMethod.POST)
//	public ResponseEntity<?> savepicture(@RequestBody ItemDataDto itempicture) throws Exception {
//
//		if (this.itemrepo.existsByitempicture(itempicture.getItempicture()))
//		  return ResponseEntity
//				.badRequest()
//				.body("Error: picture is already included!");
//		else
//			itemsdetails.save(itempicture);
//
//		return ResponseEntity.ok(itempicture);
//	}
//}
