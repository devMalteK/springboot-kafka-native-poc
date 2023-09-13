package de.kochnetonline.sbkanap.processor;

import de.kochnetonline.sbkanap.mapper.KafkaMapper;
import de.kochnetonline.sbkanap.mapper.PersistanceMapper;
import de.kochnetonline.sbkanap.model.kafka.MyKafkaMessage;
import de.kochnetonline.sbkanap.model.persistance.PersistanceObject;
import de.kochnetonline.sbkanap.service.PersistanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * consumes messages from kafka and persists them
 */
@Component
@Slf4j
public class MessageProcessor {
    private PersistanceService persistanceService;

    @Autowired
    public MessageProcessor(PersistanceService persistanceService) {
        this.persistanceService = persistanceService;
    }

    /**
     * consumes messages from kafka and persists them
     *
     * @param message
     * @throws Exception
     */
    @KafkaListener(topics = "${sbkanap.topic-name}")
    public void processMessage(@Payload final Message<String> message) throws Exception {
        try {
            MyKafkaMessage myKafkaMessage = KafkaMapper.mapToMyKafkaMessage(message.getPayload());
            PersistanceObject persistanceObject = PersistanceMapper.mapToPersistanceObject(myKafkaMessage);
            persistanceService.saveData(persistanceObject);
        } catch (Exception e) {
            log.error("Error while processing message [{}]", message, e);
            throw e;
        }
    }
}
