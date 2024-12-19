package com.example.nmc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {
   @Value("jdbc:postgresql://localhost:5432/NMC")
   private String url;
   @Value("postgres")
   private String username;
   @Value("postgres")
   private String password;

   @Bean
   public DataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setUrl(this.url);
      dataSource.setUsername(this.username);
      dataSource.setPassword(this.password);
      return dataSource;
   }
}
