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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users")
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;	

	@Column(nullable = false)
	private String phonenumber;

	@Column(nullable = false)
	private String username;

	@Column()
	private String password;

	@Column()
	private String email;

	@Column()
	private String address;
	
	@ManyToMany(fetch = FetchType.EAGER)
	 
	@JoinTable(name = "user_role",
	joinColumns = {
			@JoinColumn(name="user_id")
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Long getID() {
		return ID;
	}
	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public UserData() {}

	public UserData( String username, String password, String email, String phonenumber) {

		this.username = username;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
	}
}
	
