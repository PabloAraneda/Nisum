package cl.nisum.rest.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.nisum.rest.api.data.dto.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	
}