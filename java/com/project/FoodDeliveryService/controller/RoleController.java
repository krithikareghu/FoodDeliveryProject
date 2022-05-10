package com.project.FoodDeliveryService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Service.CustomUserDetailService;
import com.project.FoodDeliveryService.Service.CustomeruserDetailsService;
import com.project.FoodDeliveryService.Service.Roleservice;
import com.project.FoodDeliveryService.dto.Roletouserdto;

@RestController
public class RoleController {
	@Autowired
	private CustomeruserDetailsService customeruserDetailsService;
	
	@Autowired
	private Roleservice roleservice;
	
	
	@PostMapping("/createNewRole")
	public Roledata createNewRole( @RequestBody Roledata role) {
		Roledata roledata= roleservice.createNewRole(role);
		System.out.println(roledata);
		return roledata;
	
	}
	@PostMapping("/admin/addroletouser")
	public ResponseEntity<?> saveroletouser(@RequestBody Roletouserdto data){
		ResponseEntity<?>responseEntity=  
				customeruserDetailsService.addroletouser(data.getPhonenumber(), data.getRolename());
		return ResponseEntity.ok().body(responseEntity);

}
}
