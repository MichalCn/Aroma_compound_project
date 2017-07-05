package pl.coderslab.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="combinations")
public class Combination {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 50)
	private String title;
	
	@Size(max = 16)
	private String notes;
	
//	@NotBlank	// problemy z podaniem parametru z zewatrz formularza do poprawnej walidacji
	@ManyToOne
	private User user;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Ingredient> ingredients;
	
	//private List<Integer> amounts;
	
	@CreationTimestamp
	private Date created;
	
	//########## GET-SET #############



	@Override
	public String toString() {
		return "Combination [id=" + id + ", title=" + title + ", notes=" + notes + ", user=" + user + ", ingredients="
				+ ingredients + ", created=" + created + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getIngredientNames() {
		String names = "";
		for (int i = 0; i < ingredients.size(); i++) {
			names += ingredients.get(i).getName();
			names += ", ";
		}
	
		return names;
	}
	
}
