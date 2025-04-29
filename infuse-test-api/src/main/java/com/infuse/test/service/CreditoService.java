package com.infuse.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infuse.test.exception.NotFoundException;
import com.infuse.test.repository.CreditoRepository;
import com.infuse.test.response.CreditoResponse;

@Service
public class CreditoService {
	
	@Autowired
	private CreditoRepository creditoRepository;

	public List<CreditoResponse> listByNumeroNfse(String numeroNfse) {
		return creditoRepository.findByNumeroNfse(numeroNfse)
			.stream()
			.map(CreditoResponse.mapper)
			.toList();
	}
	
	public CreditoResponse getByNumeroCredito(String numeroCredito) {
		return creditoRepository.findTopByNumeroCredito(numeroCredito)
			.map(CreditoResponse.mapper)
			.orElseThrow(() -> new NotFoundException("Não encontrou crédito de número %s.", numeroCredito));
	}
}