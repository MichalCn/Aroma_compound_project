package pl.coderslab.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name="ingredients")
public class FpIngredient {
	
	private Integer id;
	private String name;
	private String description;
	private List<String> links;
	private String image;
	private String category;
	private List<String> aromas;
	//energy kj
	//protein gram/%
	
	public void fillExampleIngredient() {
		this.setId(4243);;
		this.setName("Angelica");
		this.setDescription("The garden angelic, commonly known simply as angelica, is a herbaceous plant which grows in subartic regions. Crystallized strips of young angelica stems and midribs are green in colour and are sold as decorative and flavoursome cake decoration material, but may also be enjoyed on their own.");
		this.setImage("/images/406");
		this.setCategory("/taxonomies/ingredients/categories/12");
		this.setAromas(Arrays.asList("/taxonomies/ingredients/aromas/2","/taxonomies/ingredients/aromas/3"));
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public List<String> getLinks() {
		return links;
	}
	public void setLinks(List<String> links) {
		this.links = links;
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

	public List<String> getAromas() {
		return aromas;
	}

	public void setAromas(List<String> aromas) {
		this.aromas = aromas;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", description=" + description + ", links=" + links
				+ ", image=" + image + ", category=" + category + ", aromas=" + aromas + "]";
	}

}

