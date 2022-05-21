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
import javax.persistence.Lob;
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
	private String restaurantname;
	
	@Column(nullable = false)
	private String restaurantcontact;
	
	@Column(nullable = false)
	private String restaurantEmail;
	
	@Column(nullable = false)
	private String Restaurantpassword;
	
	@Column
	
	private String Restaurantdescription;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	@JoinTable(name = "restaurant_role",
	joinColumns = {
			@JoinColumn(name="restauarnt_id")
	},
	inverseJoinColumns = {
			@JoinColumn(name="role_id")
	})
	
	private Set<Roledata>roles=new HashSet<>();


	public Set<Roledata> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roledata> roles) {
		this.roles = roles;
	}

	public String getRestaurantcontact() {
		return restaurantcontact;
	}

	public void setRestaurantcontact(String restaurantcontact) {
		this.restaurantcontact = restaurantcontact;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}

	public String getRestaurantpassword() {
		return Restaurantpassword;
	}

	public void setRestaurantpassword(String restaurantpassword) {
		Restaurantpassword = restaurantpassword;
	}

	public String getRestaurantdescription() {
		return Restaurantdescription;
	}

	public void setRestaurantdescription(String restaurantdescription) {
		Restaurantdescription = restaurantdescription;
	}
	
	@JsonIgnore
	@ManyToMany(mappedBy = "category_restaurants",cascade = CascadeType.ALL)
	
	private Set<Categorydata>category_restauarant=new HashSet<>();
	
	
	public Set<Categorydata> getCategory_restauarant() {
		return category_restauarant;
	}

	public void setCategory_restauarant(Set<Categorydata> category_restauarant) {
		this.category_restauarant = category_restauarant;
	}
	
	@ManyToMany(cascade =CascadeType.REMOVE,fetch = FetchType.LAZY)
	@JoinTable(
			name="Restaurant_items",joinColumns = @JoinColumn(name="restaurant_id", updatable = true),
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
	

	public String getRestaurantname() {
		return restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public boolean items_restaurant(ItemsData itemsData) {
	boolean contain=items.contains(itemsData);
	System.out.println(contain);
	
		if(contain==true)
		{
			return true;
		}
		else {
			items.add(itemsData);
			
			return false;
		}
		
	}
	



	

}
