package com.pinnet.batch.listener;

import com.pinnet.batch.listener.handler.UserListener;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfiguration {

    @Bean(name = "userListener")
    public JobExecutionListener userListener() {
        return new UserListener();
    }
}
