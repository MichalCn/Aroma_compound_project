package pl.coderslab.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.coderslab.model.Ingredient;
import pl.coderslab.repository.IngredientRepository;

@Controller
@RequestMapping("/ingredientdao")
public class IngredientApiDao {
	
	@Autowired
	IngredientRepository ingredientRepository;
		
	@RequestMapping(path="/load", method= RequestMethod.POST)
	@ResponseBody
	public String addBookTest(@RequestBody Ingredient ingredient){
		ingredientRepository.save(ingredient);
		System.out.println(ingredient.getName());
		return "Ingredient added, id: "+ingredient.getId();
	}
	
//	JSON
//	{"id":2,"name":"Pinaple","description":"","links":"","image":"","category":"","aromas":""}
	
	@RequestMapping(path="/getjson", method= RequestMethod.GET)
	@ResponseBody
	public Ingredient getBookTest(){
		return ingredientRepository.getOne(2L);
	}
	
	/*
	 Wszystko czego nam brakowało to dodanie Adnotacji @RequestBody przed nazwa książki. 
	 Spring sam wyłapuje, ze to json i od razu tworzy obiekt book. 
	 */
	
//	@PostMapping("/add")
//	@ResponseBody
//	public String setBook(HttpServletRequest request) {
//		try {
//			// optional - use StringBuffer to get all possible lines of request content 			
//			BufferedReader reader = request.getReader();
//			String json = reader.readLine();
//			// optional - parse json String to JsonObject, handled by 'Jackson'
//			Book book = new ObjectMapper().readValue(json, Book.class);
//			this.bookService.addBook(book);
//			return "New book added.";
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "Error!";
//		}
//		
//	}

//	JSON
//	list.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
	
//	############### METHODS
//	public Book getBook(Long id) {
//		for (Book book : list) {
//			if (book.getId() == id) {
//				return book;
//			}
//		} 
//		return null;
//	}
	
//	public List<Book> getList() {
//		return list;
//	} 
	
//	############## JSON CREATOR
//	@JsonCreator
//	public Book(@JsonProperty("id") Long id, @JsonProperty("isbn") String isbn, @JsonProperty("title") String title, 
//			@JsonProperty("author") String author, @JsonProperty("publisher") String publisher, @JsonProperty("type") String type) {
//		this.id = id;
//		this.isbn = isbn;
//		this.title = title;
//		this.author = author;
//		this.publisher = publisher;
//		this.type = type;
//	}

}
