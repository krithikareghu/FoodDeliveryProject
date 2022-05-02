package com.project.FoodDeliveryService.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name = "restaurants")
public class RestaurantData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(nullable = false)
	private String restaurantname;
	
	@ManyToMany(cascade = { CascadeType.ALL})
	@JoinTable(
			name="Restaurant_items",joinColumns = @JoinColumn(name="restaurant_id"),
			inverseJoinColumns = @JoinColumn(name="items_id"))
	
	
	private Set<ItemsData>items=new HashSet<ItemsData>();
	

	public Set<ItemsData> getItems() {
		return items;
	}

	public void setItems(Set<ItemsData> items) {
		this.items = items;
	}

	public RestaurantData() {
	}
	
	public RestaurantData(String restaurantname) {

		this.restaurantname = restaurantname;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getRestaurantname() {
		return restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public void items_restaurant(ItemsData itemsData) {
		// TODO Auto-generated method stub
		items.add(itemsData);
		
	}


	

}
