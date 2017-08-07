package pl.coderslab.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import pl.coderslab.model.Ingredient;

@Repository
public class IngredientDao {
	
	public HttpURLConnection setConnection(String path) {
		HttpURLConnection conn = null; 
		try {

			URL url = new URL("https://api.foodpairing.com/"+path);	//you can do it with the standard Java API. Check out URL, URLConnection, and maybe HttpURLConnection from package java.net.
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("X-Application-ID", "4a6a4d5e");
			conn.setRequestProperty("X-Application-Key", "3cdc209a28cdb60aae1f8e52b2ef48c2");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

		return conn;

	}
	
	public String getIngredientFromApiById(Integer id) {
		String output = null;
		try {

			HttpURLConnection conn = setConnection("ingredients/" + id);
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (IOException e) {
			e.printStackTrace();

		}

		return output;

	}
	
	public String getAllIngredientsFromApi() {
		return null;
	}
	
	// ADD THROUGH MOCK API BY NAME
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
	


}
