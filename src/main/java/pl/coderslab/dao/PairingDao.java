package pl.coderslab.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import pl.coderslab.model.Ingredient;
import pl.coderslab.model.Pairing;
import pl.coderslab.repository.PairingRepository;

@Repository
public class PairingDao {
	
	@Autowired
	PairingRepository pairingRepository;
	
	// ADD THROUGH API BY NAME
	public Pairing getPairingFromApi(String name) {
		Pairing pairing = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			pairing = restTemplate.getForObject("http://localhost:8081/getFromApi/pairing/"+name, Pairing.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pairing;
	}

}
