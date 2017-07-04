package pl.coderslab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="pairings")
public class Pairing {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Ingredient ingredient1;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Ingredient ingredient2;
	
	@Min(0)
	@Max(1)
	@Column(precision = 2, scale = 1)
	private Double rel;
	
//	private Integer rel;	// uwaga, idzie wartość składnik-składnik i składnik-all
//	private Integer abs;	// uwaga, idzie wartość składnik-składnik i składnik-all
	//private String aroma;	// nie idzie z API
	
//	########## GET-SET

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ingredient getIngredient1() {
		return ingredient1;
	}

	public void setIngredient1(Ingredient ingredient1) {
		this.ingredient1 = ingredient1;
	}

	public Ingredient getIngredient2() {
		return ingredient2;
	}

	public void setIngredient2(Ingredient ingredient2) {
		this.ingredient2 = ingredient2;
	}

	public Double getRel() {
		return rel;
	}

	public void setRel(Double rel) {
		this.rel = rel;
	}
	

	
	

}

