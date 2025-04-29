package com.infuse.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infuse.test.entity.Credito;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Long> {

	List<Credito> findByNumeroNfse(String numeroNfse);
	
	Optional<Credito> findTopByNumeroCredito(String numeroCredito);
}