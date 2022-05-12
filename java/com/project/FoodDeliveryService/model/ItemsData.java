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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "items")
public class ItemsData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(nullable = false)
	private String itemname;
	
	@Column(nullable = false)
	private String itemprice;
	
	 @NonNull
	public String getItemprice() {
		return itemprice;
	}

	public void setItemprice(String itemprice) {
		this.itemprice = itemprice;
	}
	
	@Lob
	@Column
	private byte[] itempicture;
	
	
//	@JsonIgnore
//	@ManyToMany(mappedBy = "items")	
//   private Set<RestaurantData>restaurantDatas=new HashSet<>();
//	
//	public Set<RestaurantData> getRestaurantDatas() {
//	return restaurantDatas;
//}

//public void setRestaurantDatas(Set<RestaurantData> restaurantDatas) {
//	this.restaurantDatas = restaurantDatas;
//}

 @JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="item_category",joinColumns = 
			@JoinColumn(name="item_id")
	 ,inverseJoinColumns =@JoinColumn(name= "category_id") )
	
	private Set<Categorydata>categorydatas=new HashSet<Categorydata>();
	
	public Set<Categorydata> getCategorydatas() {
		return categorydatas;
	}

	public void setCategorydatas(Set<Categorydata> categorydatas) {
		this.categorydatas = categorydatas;
	}


	public ItemsData() {
	}

	

	public byte[] getItempicture() {
		return itempicture;
	}

	public void setItempicture(byte[] itempicture) {
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
	public void category_items(Categorydata categorydata) {
		categorydatas.add(categorydata);
		
	}
	
	}

	


