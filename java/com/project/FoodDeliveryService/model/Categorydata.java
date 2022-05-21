package com.project.FoodDeliveryService.Model;

import java.lang.annotation.Repeatable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "FoodCategory")
public class Categorydata {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private String categoryname;
	
	
	@Lob
	@Column
	private byte[] categorypicture;
	
//	@OneToMany(fetch = FetchType.EAGER,orphanRemoval = true )
//	@JoinTable(name="item_category",joinColumns = 
//			@JoinColumn(name="item_id")
//	 ,inverseJoinColumns =@JoinColumn(name="category_id") )
//	private Set<ItemsData>itemsDatas=new HashSet<ItemsData>(); 
//	
//

	
	
//	public void category_items(ItemsData categorydata) {
//		itemsDatas.add(categorydata);
//		
//	}
//
//	public Set<ItemsData> getItemsDatas() {
//		return itemsDatas;
//	}
//	public void setItemsDatas(Set<ItemsData> itemsDatas) {
//		this.itemsDatas = itemsDatas;
//	}




	@ManyToMany(cascade = { CascadeType.REMOVE},fetch = FetchType.EAGER)
	@JoinTable(
			name="category_restaurants",joinColumns = @JoinColumn(name="category_id"),
			inverseJoinColumns = @JoinColumn(name="restaurant_id"))
	
	private Set<RestaurantData>category_restaurants=new HashSet<RestaurantData>();
	
	public Set<RestaurantData> getCategory_restaurants() {
		return category_restaurants;
	}
	public void setCategory_restaurants(Set<RestaurantData> category_restaurants) {
		this.category_restaurants = category_restaurants;
	}

	public byte[] getCategorypicture() {
		return categorypicture;
	}
	public void setCategorypicture(byte[] categorypicture) {
		this.categorypicture = categorypicture;
	}
	public Categorydata() {
	}
	
	
	public Categorydata(String name, byte[] pic) {
		this.categoryname=name;
		this.categorypicture=pic;
		
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	
	public String getCategoryname() {
		return categoryname;
	}
	
	public void restaurant_category(RestaurantData restaurantData) {
		category_restaurants.add(restaurantData);
		
	}
	


}
