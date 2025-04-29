package com.infuse.test.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisher {

    private static final String TOPIC = "consulta-topico";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishConsulta(String mensagem) {
        kafkaTemplate.send(TOPIC, mensagem);
    }
}