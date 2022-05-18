package com.project.FoodDeliveryService.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orders")
public class OrderData {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long ID;	
		@Column(nullable = false)
	
		private String itemname;
		@Column(nullable = false)
		private String quantity;
		@Column(nullable = false)
		private int itemprice;
	
		public OrderData() {
		}
		public OrderData(String itemname, int itemprice) {
			this.itemname = itemname;
			this.itemprice = itemprice;
}
//		@JsonIgnore
//		@ManyToMany(mappedBy = "orderDatas",cascade = CascadeType.ALL)
//	    public Set<UserData>userDatas=new HashSet<UserData>();
	
		
//		public Set<UserData> getUserDatas() {
//			return userDatas;
//		}
//		public void setUserDatas(Set<UserData> userDatas) {
//			this.userDatas = userDatas;
//		}
		public String getItemname() {
			return itemname;
		}
		public void setItemname(String itemname) {
			this.itemname = itemname;
		}
		public String getQuantity() {
			return quantity;
		}
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}
		public int getItemprice() {
			return itemprice;
		}
		public void setItemprice(int itemprice) {
			this.itemprice = itemprice;
		}
		
		

	}




