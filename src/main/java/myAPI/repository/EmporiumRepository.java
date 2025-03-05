package myAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myAPI.model.Emporium;

@Repository
public interface EmporiumRepository extends JpaRepository<Emporium, Long> {
	
}
