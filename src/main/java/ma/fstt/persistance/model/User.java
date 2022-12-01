package ma.fstt.persistance.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="user")
public class User  {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long Id;

	   private String Name;
	   private String email;
	   private String password;
	   
	  


	   
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(String name, String email, String password) {
		super();
this.Name=name;
		this.email = email;
		this.password = password;
	}
	public User(Long id) {
		super();
		Id = id;
	}
	public User() {
		super();
	}
	
}

		   
