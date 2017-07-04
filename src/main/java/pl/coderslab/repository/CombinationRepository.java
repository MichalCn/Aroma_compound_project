package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Combination;

public interface CombinationRepository extends JpaRepository<Combination, Long> {

	List<Combination> findByUserId(Long id);
	
}