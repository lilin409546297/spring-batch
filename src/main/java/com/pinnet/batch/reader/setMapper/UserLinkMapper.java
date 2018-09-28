package com.pinnet.batch.reader.setMapper;

import com.pinnet.domain.User;
import org.springframework.batch.item.file.LineMapper;

public class UserLinkMapper implements LineMapper<User> {

    @Override
    public User mapLine(String s, int i) throws Exception {
        String[] strs = s.split(",");
        User user = new User();
        user.setId(Long.valueOf(strs[0]));
        user.setName(String.valueOf(strs[1]));
        user.setAge(Integer.valueOf(strs[2]));
        return user;
    }
}
