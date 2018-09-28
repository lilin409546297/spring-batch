package com.pinnet.batch.processor.handler;

import com.pinnet.domain.User;
import org.springframework.batch.item.ItemProcessor;

public class UserItemProcessor implements ItemProcessor<User, User> {

    @Override
    public User process(User user) throws Exception {
        System.out.println(user + "processor");
        return user;
    }
}
