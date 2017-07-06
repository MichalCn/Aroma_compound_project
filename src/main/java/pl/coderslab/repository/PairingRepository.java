package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Pairing;

public interface PairingRepository extends JpaRepository<Pairing, Long> {

	List<Pairing> findByIngredient1Id(Long id);
	List<Pairing> findByIngredient2Id(Long id);
	Pairing findFirstByIngredient1IdAndIngredient2Id(Long id1, Long id2);
}