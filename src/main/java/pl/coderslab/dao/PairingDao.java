package pl.coderslab.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import pl.coderslab.model.Pairing;
import pl.coderslab.repository.PairingRepository;

@Repository
public class PairingDao {
	
	@Autowired
	PairingRepository pairingRepository;
	
	// ADD FROM API BY NAME
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
