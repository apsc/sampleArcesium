package com.arcesium;

import javax.sql.DataSource;

import com.arcesium.util.DataSourceProperties;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.io.IOException;

/**
 * Created by amanpsc on 12/11/15.
 */

@Configuration
@MapperScan("com.arcesium.mapper")
public class Configurator {
    private static final Logger LOGGER = LoggerFactory.getLogger(Configurator.class);
    private final DataSourceProperties config = getConfig();

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

//        dataSource.setDriverClassName(this.config.getProperty("driver"));
//        dataSource.setUrl(this.config.getProperty("url"));
//        dataSource.setUsername(this.getConfig().getProperty("username"));
//        dataSource.setPassword(this.config.getProperty("password"));

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/arcesium");
        dataSource.setUsername("root");
        dataSource.setPassword(".");

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        return sessionFactory.getObject();
    }

    private DataSourceProperties getConfig() {
        try {
            return new DataSourceProperties("config.properties");
        } catch (IOException e) {
            String message = "Error while loading config: config.properties";
            LOGGER.error(message);
            throw new RuntimeException(message);
        }
    }
}
