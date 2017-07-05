package pl.coderslab.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import pl.coderslab.model.Ingredient;
import pl.coderslab.repository.IngredientRepository;

@Repository
public class IngredientDao {
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	// ADD THROUGH API BY NAME
	public Ingredient getIngredientFromApi(String name) {
		Ingredient ingredient = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ingredient = restTemplate.getForObject("http://localhost:8081/getFromApi/ingredient/"+name, Ingredient.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ingredient;
	}
	
	
////	JSON EXAMPLES
////	{"id":2,"name":"Pinaple","description":"","links":"","image":"","category":"","aromas":""}
//		{"name":"Pinaple"}

//	@RequestMapping(path="/getjson", method= RequestMethod.GET)
//	@ResponseBody
//	public Ingredient getBookTest(){
//		return ingredientRepository.getOne(2L);
//	}
	
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
