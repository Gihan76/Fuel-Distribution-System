package com.gihan.allocationservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfigAllocation {

    @Bean
    public NewTopic scheduleTopic(){
        return TopicBuilder.name("scheduletopic").build();
    }

    @Bean
    public NewTopic allocationFailedTopic(){
        return TopicBuilder.name("schedulefail").build();
    }
}
