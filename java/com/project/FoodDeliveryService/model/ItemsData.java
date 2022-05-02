package com.project.FoodDeliveryService.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "items")
public class ItemsData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(nullable = false)
	private String itemname;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "items")
	private Set<RestaurantData>restaurantDatas=new HashSet<>();

	public Set<RestaurantData> getRestaurantDatas() {
		return restaurantDatas;
	}

	public void setRestaurantDatas(Set<RestaurantData> restaurantDatas) {
		this.restaurantDatas = restaurantDatas;
	}

	public ItemsData() {
	}

	public ItemsData(String itemname) {
		this.itemname = itemname;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	}

	


