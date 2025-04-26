package com.excelr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private static final String TOPIC = "excelr_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        return "✅ Sent: " + message;
    }

    @KafkaListener(topics = TOPIC, groupId = "excelr-group")
    public void receive(String message) {
        System.out.println("📩 Received: " + message);
        // Add DB save, notification trigger, etc. here
    }
}
