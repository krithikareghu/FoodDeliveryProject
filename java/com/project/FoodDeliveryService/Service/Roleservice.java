package com.project.FoodDeliveryService.Service;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.repository.RoleRepository;

@Service
public class Roleservice {

	@Autowired
	private RoleRepository roleRepository;

	public Roledata createNewRole(Roledata role) {
//		
//		Roledata roledata = roleRepository.findByrolename(role.getRolename());
//		
//		System.out.println(roledata.getRolename()==role.getRolename());
//		System.out.println(role.getRolename());
//		
//		if (role.getRolename()== roledata.getRolename()) {
//			System.out.println("hi");
//			return null;
//		}
		return roleRepository.save(role);
	}

}
