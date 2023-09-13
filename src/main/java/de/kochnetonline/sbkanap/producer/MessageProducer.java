package de.kochnetonline.sbkanap.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.kochnetonline.sbkanap.config.KafkaProducerConfig;
import de.kochnetonline.sbkanap.config.SbKaNaPConfig;
import de.kochnetonline.sbkanap.model.kafka.MyKafkaMessage;
import de.kochnetonline.sbkanap.model.kafka.MyKafkaMessageKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * produces a random Message every second
 */
@Component
@EnableScheduling
@Slf4j
public class MessageProducer {
    private KafkaProducerConfig kafkaProducerConfig;
    private SbKaNaPConfig sbKaNaPConfig;

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public MessageProducer(KafkaProducerConfig kafkaProducerConfig, SbKaNaPConfig sbKaNaPConfig) {
        this.kafkaProducerConfig = kafkaProducerConfig;
        this.sbKaNaPConfig = sbKaNaPConfig;
    }

    @Scheduled(fixedDelay = 1000)
    public void produceMessage() throws ExecutionException, InterruptedException, JsonProcessingException, TimeoutException {
        var messageKey = new MyKafkaMessageKey(UUID.randomUUID());
        var message = new MyKafkaMessage(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        var messageKeyString = objectMapper.writeValueAsString(messageKey);
        var messageString = objectMapper.writeValueAsString(message);
        kafkaProducerConfig.kafkaTemplate().send(sbKaNaPConfig.getTopicName(), messageKeyString, messageString).get(30, TimeUnit.SECONDS);
        log.info("Message sent key: [{}] value: [{}]", messageKeyString, messageString);
    }
}
