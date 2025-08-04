package com.coursegen.coursegen_backend.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;

import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class AwsConfig {
    @Value("${aws.accessKeyId}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;
    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder()
                .region(Region.of("ap-south-1")) // Change to your region
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                 AwsBasicCredentials.create(accessKey, secretKey)
                        )
                )
                .build();
    }
}
