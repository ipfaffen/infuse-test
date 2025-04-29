package com.infuse.test.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infuse.test.exception.NotFoundException;
import com.infuse.test.kafka.KafkaPublisher;
import com.infuse.test.service.CreditoService;

@RestController
@RequestMapping("/creditos")
@CrossOrigin(origins="*", allowedHeaders="*")
public class CreditoApi {
	
	@Autowired
	private CreditoService creditoService;
    
    @Autowired
    private KafkaPublisher kafkaPublisher;

    private static final Boolean KAFKA_ENABLED = false;

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<?> list(
        @PathVariable("numeroNfse") String numeroNfse) {  
        if(KAFKA_ENABLED) kafkaPublisher.publishConsulta("Consulta realizada para NFS-e: " + numeroNfse);
        return ResponseEntity.ok(
            creditoService.listByNumeroNfse(numeroNfse));
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<?> get(
        @PathVariable("numeroCredito") String numeroCredito) {
        if(KAFKA_ENABLED) kafkaPublisher.publishConsulta("Consulta realizada para número de crédito " + numeroCredito);
        return ResponseEntity.ok(
            creditoService.getByNumeroCredito(numeroCredito));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getReason());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }	    
}