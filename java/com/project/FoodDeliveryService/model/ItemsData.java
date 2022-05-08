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
import javax.persistence.OneToMany;
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
	
	@Column
	private String itempicture;
	
	
//	@JsonIgnore
//	@ManyToMany(mappedBy = "items")
//	
//   private Set<RestaurantData>restaurantDatas=new HashSet<>();
	
//	public Set<RestaurantData> getRestaurantDatas() {
//	return restaurantDatas;
//}
//
//public void setRestaurantDatas(Set<RestaurantData> restaurantDatas) {
//	this.restaurantDatas = restaurantDatas;
//}
	

	@JsonIgnore
	@ManyToMany(mappedBy = "category_ItemsDatas")
	
	private Set<Categorydata>categorydatas=new HashSet<>();
	
	public Set<Categorydata> getCategorydatas() {
		return categorydatas;
	}

	public void setCategorydatas(Set<Categorydata> categorydatas) {
		this.categorydatas = categorydatas;
	}
	
	



	public ItemsData() {
	}

	public ItemsData(String itemname,String itempicture) {
		this.itemname = itemname;
		this.itempicture=itempicture;
	}

	public String getItempicture() {
		return itempicture;
	}

	public void setItempicture(String itempicture) {
		this.itempicture = itempicture;
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

	


