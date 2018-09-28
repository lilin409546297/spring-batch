package com.pinnet.batch.writer;

import com.pinnet.batch.writer.handler.UserItemWriter;
import com.pinnet.domain.User;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfiguration {

    @Bean(name = "userItemWriter")
    public ItemWriter<User> userItemWriter() {
        return new UserItemWriter();
    }
}
