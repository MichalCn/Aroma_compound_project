package pl.coderslab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ingredients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 20)
	@Column(unique=true)
	private String name;
	
	@Size(max = 600)
	@Column(columnDefinition="TEXT")
	private String description;
	private String links;
	private String image;
	private String category;
	private String aromas;
	
	public Ingredient() {
	}

	public Ingredient(Long id, String name, String description, String links, String image, String category,
			String aromas) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.links = links;
		this.image = image;
		this.category = category;
		this.aromas = aromas;
	}
	
//	########### GET-SET ##############

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getAromas() {
		return aromas;
	}

	public void setAromas(String aromas) {
		this.aromas = aromas;
	}	

}

