package com.pinnet.batch.writer.handler;

import com.pinnet.domain.User;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserItemWriter implements ItemWriter<User>{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void write(List<? extends User> list) throws Exception {
        String sql = "insert into user (id, name, age) values (?,?,?)";
        if (list != null && !list.isEmpty()) {
            list.stream().forEach(user -> {
                jdbcTemplate.update(sql, new Object[]{user.getId(), user.getName(), user.getAge()});
            });
            System.out.println(System.currentTimeMillis());
            System.out.println(list);
        }
    }
}
