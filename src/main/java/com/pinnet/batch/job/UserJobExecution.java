package com.pinnet.batch.job;

import com.pinnet.batch.processor.ProcessorConfiguration;
import com.pinnet.batch.reader.ReaderConfiguration;
import com.pinnet.batch.writer.WriterConfiguration;
import com.pinnet.domain.User;
import com.pinnet.jdbc.DataSourceConfiguration;
import com.pinnet.batch.listener.ListenerConfiguration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {DataSourceConfiguration.class,
        ReaderConfiguration.class,
        ProcessorConfiguration.class,
        WriterConfiguration.class,
        ListenerConfiguration.class})
public class UserJobExecution {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private FlatFileItemReader<User> userFlatFileItemReader;

    @Autowired
    private ItemProcessor<User, User> userItemProcessor;

    @Autowired
    private ItemWriter<User> userItemWriter;

    @Autowired
    private JobExecutionListener userListener;

    @Bean(name = "userJob")
    public Job userJob() {
        return jobBuilderFactory.get("userJob").start(userStep()).listener(userListener).build();
    }

    @Bean
    public Step userStep() {
        return stepBuilderFactory.get("userStep")
                .<User,User>chunk(10)
                .reader(userFlatFileItemReader)
                .processor(userItemProcessor)
                .writer(userItemWriter)
                .build();
    }
}
