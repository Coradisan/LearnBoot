package com.pkfare.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Admin on 2017/8/18 0018.
 */
@Configuration
public class DataSourceConfig {


    /**
     * Data Sources
     */

    @Bean(name = "javahonkDataSource")
//        @Primary
    @ConfigurationProperties(prefix = "db.testDB")
    public DataSource fcipDataSource() {
        return DataSourceBuilder.create().build();
    }


    /**
     * Spring JDBC Templates
     */

    @Bean(name = "jdbcJavahonk")
    @Autowired
    public JdbcTemplate fcipJdbcTemplate(@Qualifier("javahonkDataSource") DataSource dsSlave) {
        return new JdbcTemplate(dsSlave);
    }
}
