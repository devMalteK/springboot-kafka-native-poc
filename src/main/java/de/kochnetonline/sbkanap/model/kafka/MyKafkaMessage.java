package de.kochnetonline.sbkanap.model.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyKafkaMessage implements Serializable {
    private String value1;
    private String value2;
}
