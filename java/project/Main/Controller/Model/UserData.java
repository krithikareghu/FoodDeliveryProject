package project.Main.Controller.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="users" )
public class UserData {

//	@Id
//   @GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
    private String firstname;
     
    @Column( nullable=false)
    private String lastname;
    
    public UserData()
	{
    	System.out.println("default constructor called");
	}
	public UserData (String email,String password,String firstname,String lastname) {
		
		this.email=email;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		System.out.println("parametrised constructor called");
	}
    public  Long getId() {
		return id;
	}
    public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}

