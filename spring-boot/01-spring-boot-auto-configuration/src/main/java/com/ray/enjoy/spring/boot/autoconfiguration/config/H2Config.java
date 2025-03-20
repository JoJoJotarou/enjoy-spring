package com.ray.enjoy.spring.boot.autoconfiguration.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class H2Config {

    // @Bean
    // public DataSource dataSource() {
    //     return new EmbeddedDatabaseBuilder()
    //             .generateUniqueName(true)
    //             .setType(EmbeddedDatabaseType.H2)
    //             .addScripts("h2/data.sql")
    //             .build();
    // }
}
