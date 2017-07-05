package pl.coderslab.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	//private List<String> links;
	private String links;
	private String image;
	private String category;
	//private List<String> aromas;
	private String aromas;
	//energy kj
	//protein gram/%
	
//	public Ingredient() {
//	}
//
//	public Ingredient(Long id, String name, String description, String links, String image, String category,
//			String aromas) {
//		
//		this.id = id;
//		this.name = name;
//		this.description = description;
//		this.links = links;
//		this.image = image;
//		this.category = category;
//		this.aromas = aromas;
//	}





//	public void fillExampleIngredient() {
//		this.setId(4243);;
//		this.setName("Angelica");
//		this.setDescription("The garden angelic, commonly known simply as angelica, is a herbaceous plant which grows in subartic regions. Crystallized strips of young angelica stems and midribs are green in colour and are sold as decorative and flavoursome cake decoration material, but may also be enjoyed on their own.");
//		this.setImage("/images/406");
//		this.setCategory("/taxonomies/ingredients/categories/12");
//		this.setAromas(Arrays.asList("/taxonomies/ingredients/aromas/2","/taxonomies/ingredients/aromas/3"));
//	}
	
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
//	public List<String> getLinks() {
//		return links;
//	}
//	public void setLinks(List<String> links) {
//		this.links = links;
//	}

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

//	public List<String> getAromas() {
//		return aromas;
//	}
//
//	public void setAromas(List<String> aromas) {
//		this.aromas = aromas;
//	}
	

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

	


//	@Override
//	public String toString() {
//		return "Ingredient [id=" + id + ", name=" + name + ", description=" + description + ", links=" + links
//				+ ", image=" + image + ", category=" + category + ", aromas=" + aromas + "]";
//	}
	
	

}

