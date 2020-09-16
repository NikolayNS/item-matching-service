package com.dmitrenko.itemmatchingservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExecutorConfig {

    @Value("${magintegrator.jobengine.thread-pool-size}")
    private int poolSize;

    @Value("${magintegrator.jobengine.thread-name-prefix}")
    private String threadNamePrefix;

    @Primary
    @Bean(name = "JobEngineTaskExecutor")
    TaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(poolSize);
        taskExecutor.setMaxPoolSize(poolSize);
        taskExecutor.setThreadNamePrefix(threadNamePrefix);
        taskExecutor.initialize();

        return taskExecutor;
    }
}
