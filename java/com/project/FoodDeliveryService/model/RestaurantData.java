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

import com.fasterxml.jackson.annotation.JsonIgnore;

import antlr.collections.List;

@Entity
@Table(name = "restaurants")
public class RestaurantData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(nullable = false)
	private String restaurantname;
	
	///////////////////////////////////
	
	@JsonIgnore
	@ManyToMany(mappedBy = "category_restaurants")
	
	private Set<Categorydata>category_restauarant=new HashSet<>();
	
	
	public Set<Categorydata> getCategory_restauarant() {
		return category_restauarant;
	}

	public void setCategory_restauarant(Set<Categorydata> category_restauarant) {
		this.category_restauarant = category_restauarant;
	}

	/////////////////////////////////////////////////
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
	
	public RestaurantData( String restaurantname, String restaurantaddress, String restaurantcontact) {
	
		this.restaurantname = restaurantname;
//		this.restaurantaddress = restaurantaddress;
//		this.restaurantcontact = restaurantcontact;
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
		items.add(itemsData);
		
	}
	
	//	@Column(nullable = false)
//	private String restaurantaddress;
//	
//	@Column(nullable = false)
//	private String restaurantcontact;
//	
//	public String getRestaurantaddress() {
//		return restaurantaddress;
//	}
//
//	public void setRestaurantaddress(String restaurantaddress) {
//		this.restaurantaddress = restaurantaddress;
//	}
//
//	public String getRestaurantcontact() {
//		return restaurantcontact;
//	}
//
//	public void setRestaurantcontact(String restaurantcontact) {
//		this.restaurantcontact = restaurantcontact;
//	}

	


	

}
