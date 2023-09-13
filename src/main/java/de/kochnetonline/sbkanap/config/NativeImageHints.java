package de.kochnetonline.sbkanap.config;

import de.kochnetonline.sbkanap.model.kafka.MyKafkaMessage;
import de.kochnetonline.sbkanap.model.kafka.MyKafkaMessageKey;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;

/**
 * Native Images Hints for JacksonMapped Classes
 */
@Configuration
@RegisterReflectionForBinding({MyKafkaMessage.class, MyKafkaMessageKey.class})
public class NativeImageHints {
}
