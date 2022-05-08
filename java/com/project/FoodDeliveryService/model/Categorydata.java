package com.project.FoodDeliveryService.Model;

import java.lang.annotation.Repeatable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Categorydata {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	//@Column(nullable = false)
	private String categoryname;
	
//	@Column
//	private String categorypicture;
	
	@Lob
	@Column
	private byte[] categorypicture;
	
	@ManyToMany(cascade = { CascadeType.ALL})
	@JoinTable(
			name="category_items",joinColumns = @JoinColumn(name="category_id"),
			inverseJoinColumns = @JoinColumn(name="items_id"))
	
	private Set<ItemsData>category_ItemsDatas=new HashSet<ItemsData>();
	
	///////////////////////////////////////////
	
	@ManyToMany(cascade = { CascadeType.ALL})
	@JoinTable(
			name="restaurants_category",joinColumns = @JoinColumn(name="category_id"),
			inverseJoinColumns = @JoinColumn(name="restaurant_id"))
	
	private Set<RestaurantData>category_restaurants=new HashSet<RestaurantData>();
	
	public Set<RestaurantData> getCategory_restaurants() {
		return category_restaurants;
	}
	public void setCategory_restaurants(Set<RestaurantData> category_restaurants) {
		this.category_restaurants = category_restaurants;
	}
	
	//////////////////////////////////////
	
	
	public Set<ItemsData> getCategory_ItemsDatas() {
		return category_ItemsDatas;
	}
//	public Categorydata(String categoryname, String categorypicture) {
//		this.categoryname = categoryname;
//		this.categorypicture = categorypicture;
//		
//	}
	
	public void setCategory_ItemsDatas(Set<ItemsData> category_ItemsDatas) {
		this.category_ItemsDatas = category_ItemsDatas;
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
		// TODO Auto-generated constructor stub
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
	
	
	
	
	public void category_items(ItemsData itemsData) {
		category_ItemsDatas.add(itemsData);
		
	}
	public void restaurant_category(RestaurantData restaurantData) {
		category_restaurants.add(restaurantData);
		
	}
	

}
