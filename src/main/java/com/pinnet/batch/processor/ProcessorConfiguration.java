package com.pinnet.batch.processor;

import com.pinnet.batch.processor.handler.UserItemProcessor;
import com.pinnet.domain.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorConfiguration {

    @Bean(name = "userItemProcessor")
    public ItemProcessor<User, User> userItemProcessor() {
        return new UserItemProcessor();
    }
}
