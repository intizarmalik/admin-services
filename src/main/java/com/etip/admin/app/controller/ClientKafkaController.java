package com.etip.admin.app.controller;

import com.etip.admin.app.constants.ApplicationConstants;
import com.etip.admin.app.models.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/kafka")
public class ClientKafkaController {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    @PostMapping(value = "/addClient", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String sendToAddClientDetails(@RequestBody ClientDetails clientDetails){
        kafkaTemplate.send(ApplicationConstants.KAFKA_TOPIC_TO_ADD_CLIENT,clientDetails);
        return "published successfully.";
    }

    @PostMapping(value = "/updateClient", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String sendToUpdateClientDetails(@RequestBody ClientDetails clientDetails){
        kafkaTemplate.send(ApplicationConstants.KAFKA_TOPIC_TO_UPDATE_CLIENT,clientDetails);
        return "published successfully.";
    }

    @PostMapping(value = "/deleteClient", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String sendToDeleteClientDetails(@RequestBody Map<String,String> clientDetails){
        kafkaTemplate.send(ApplicationConstants.KAFKA_TOPIC_TO_DELETE_CLIENT,clientDetails);
        return "published successfully.";
    }

}
