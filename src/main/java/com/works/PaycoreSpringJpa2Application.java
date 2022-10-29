package com.works;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableElasticsearchRepositories
@EnableCaching
public class PaycoreSpringJpa2Application {

    public static void main(String[] args) {
        SpringApplication.run(PaycoreSpringJpa2Application.class, args);
    }

}
