package com.project.FoodDeliveryService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roledata {
	
		@Id
		private String rolename;
		
		private String roleDescription;
		
		public String getRoleDescription() {
			return roleDescription;
		}
		public void setRoleDescription(String roleDescription) {
			this.roleDescription = roleDescription;
		}
		
		public String getRolename() {
			return rolename;
		}
		public void setRolename(String rolename) {
			this.rolename = rolename;
		}
		

		


	}




