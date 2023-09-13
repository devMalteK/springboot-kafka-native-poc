package de.kochnetonline.sbkanap.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Configuration for the application
 */
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "sbkanap")
@Validated
@Data
public class SbKaNaPConfig {

    @NotBlank
    private String kafkaBootstrapServer;

    @NotBlank
    private String topicName;

    @NotBlank
    private String consumerGroup;
}
