package com.gihan.scheduleservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfigSchedule {

    @Bean
    public NewTopic deliveryTopic(){
        return TopicBuilder.name("dispatchtopic").build();
    }

    @Bean
    public NewTopic deliveryFailTopic(){
        return TopicBuilder.name("dispatchfail").build();
    }

}
