package com.pinnet.batch.reader;

import com.pinnet.batch.reader.setMapper.UserFieldSetMapper;
import com.pinnet.batch.reader.setMapper.UserLinkMapper;
import com.pinnet.domain.User;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ReaderConfiguration {

    @Bean(name = "userFlatFileItemReader")
    public FlatFileItemReader<User> userFlatFileItemReader(DefaultLineMapper<User> userDefaultLineMapper) {
        FlatFileItemReader<User> userFlatFileItemReader = new FlatFileItemReader<>();
        userFlatFileItemReader.setResource(new ClassPathResource("file/user.csv"));
        userFlatFileItemReader.setLineMapper(new UserLinkMapper());
        return userFlatFileItemReader;
    }

    @Bean(name = "userDefaultLineMapper")
    public DefaultLineMapper<User> userDefaultLineMapper() {
        DefaultLineMapper<User> userDefaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[]{"id", "name", "age"});
        userDefaultLineMapper.setLineTokenizer(lineTokenizer);
        userDefaultLineMapper.setFieldSetMapper(new UserFieldSetMapper());
        return userDefaultLineMapper;
    }
}
