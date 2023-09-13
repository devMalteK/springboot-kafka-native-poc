package de.kochnetonline.sbkanap.model.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyKafkaMessageKey implements Serializable {
    private UUID messageKey;
}
