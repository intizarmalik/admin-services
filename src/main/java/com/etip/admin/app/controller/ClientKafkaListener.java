package com.etip.admin.app.controller;

import com.etip.admin.app.constants.ApplicationConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ClientKafkaListener {

    @KafkaListener(topics = ApplicationConstants.KAFKA_TOPIC_TO_ADD_CLIENT,groupId = "groupId")
    public void listenToAddClient(Object clientDetails){
        System.out.println("client details-->"+clientDetails);
    }

}
