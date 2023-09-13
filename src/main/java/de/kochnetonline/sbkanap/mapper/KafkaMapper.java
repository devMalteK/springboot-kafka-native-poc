package de.kochnetonline.sbkanap.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.kochnetonline.sbkanap.model.kafka.MyKafkaMessage;

public class KafkaMapper {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private KafkaMapper() {
    }

    /**
     * maps a kafka message to a MyKafkaMessage
     *
     * @param message
     * @return
     * @throws JsonProcessingException
     */
    public static MyKafkaMessage mapToMyKafkaMessage(String message) throws JsonProcessingException {
        return objectMapper.readValue(message, MyKafkaMessage.class);
    }
}
