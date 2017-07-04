package pl.coderslab.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique=true)
	private String login;
	
	@NotBlank
	private String password;
	
	@Email
	private String email;
	
	//@Size(min=3, max=20)
	private String firstName;
	
	//@Size(min=3, max=20)
	private String lastName;
	
	@CreationTimestamp
	private Date registered;
	
	@AssertTrue
	private Boolean acceptRules;
	
	//@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	//private List<Tweet> tweets;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Combination> combinations;
	
	//########## GET-SET #############

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public List<Combination> getCombinations() {
		return combinations;
	}

	public void setCombinations(List<Combination> combinations) {
		this.combinations = combinations;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAcceptRules() {
		return acceptRules;
	}

	public void setAcceptRules(Boolean acceptRules) {
		this.acceptRules = acceptRules;
	}
	
	

}
