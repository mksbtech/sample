package com.milan.poc.reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.dialect.PostgresDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import com.milan.poc.reactive.repository.ReactiveEmployeeRepository;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;

@Configuration
@EnableR2dbcRepositories
public class R2DatabaseConfiguration {
	@Bean
    public ReactiveEmployeeRepository reactiveEmployeecityRepository() {
        return r2dbcRepositoryFactory().getRepository(ReactiveEmployeeRepository.class);
    }

    @Bean
    public R2dbcRepositoryFactory r2dbcRepositoryFactory() {
        RelationalMappingContext context = new RelationalMappingContext();
        context.afterPropertiesSet();
        return new R2dbcRepositoryFactory(databaseClient(), reactiveDataAccessStrategy());
    }

    @Bean
    public DatabaseClient databaseClient() {
        return DatabaseClient.create(connectionFactory());
    }
    
    @Bean
    public DatabaseClient r2dbcDatabaseClient() {
        return DatabaseClient.create(connectionFactory());
    }
    
    @Bean
    public DefaultReactiveDataAccessStrategy reactiveDataAccessStrategy() {
        return new DefaultReactiveDataAccessStrategy(new PostgresDialect());
    }

    @Bean
    public PostgresqlConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder().host("localhost").port(5432).database("poc_db").schema("reactive_poc")                 
                .username("myuser").password("start123")
                .build();
        return new PostgresqlConnectionFactory(config);
    }

}
