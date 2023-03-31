package com.disabe.kafkaConsumer.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	 //final static Logger logger = (Logger) LoggerFactory.getLogger(DemoController.class);
	 // Autowiring Kafka Template
    @Autowired 
    KafkaTemplate<String, String> kafkaTemplate;
 
    private static final String TOPIC = "NewTopic";
 
    // Publish messages using the GetMapping
    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message") final String message)
    {
 
        // Sending the message
        kafkaTemplate.send(TOPIC, message);
 
        return "Published Successfully";
    }
    
    @GetMapping("/something")
    public ResponseEntity<String> createLogs() {
        //logger.warn("Just checking");
        return ResponseEntity.ok().body("All Ok");
    }
	
}
