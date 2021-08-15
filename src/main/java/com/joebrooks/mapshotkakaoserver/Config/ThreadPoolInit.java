package com.joebrooks.mapshotkakaoserver.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ThreadPoolInit {

    @Bean("driverExecutor")
    public Executor setExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(4);
        threadPoolTaskExecutor.setMaxPoolSize(4);
        threadPoolTaskExecutor.setQueueCapacity(10);
        threadPoolTaskExecutor.setThreadNamePrefix("executor-");

        return threadPoolTaskExecutor;
    }
}
