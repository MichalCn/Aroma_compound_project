package pl.coderslab.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name="pairings")
public class Pairing {
	
	private List<Ingredient> ingredients;
	private Integer rel;	// uwaga, idzie wartość składnik-składnik i składnik-all
	private Integer abs;	// uwaga, idzie wartość składnik-składnik i składnik-all
	//private String aroma;	// nie idzie z API

}

