package com.issueking.test.base.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

//import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.jolbox.bonecp.BoneCPDataSource;

/*
 * root-context.xml에 역할 대신 수행
 * 
 * propertyholder 설정 , datasource 설정
 * 
 * */

@Configuration
@MapperScan(basePackages = "com.issueking.test.api.persistance")
public class DBConfig {
    
    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;
    
    @Value("${jdbc.url}")
    private String jdbcUrl;
    
    @Value("${jdbc.username}")
    private String jdbcUsername;
    
    @Value("${jdbc.password}")
    private String jdbcPassword;
    
    private static final String APP_CONFIG_FILE_PATH = "/config/properties/jdbc.properties";
    
    @PostConstruct
    public void init() {
        System.out.println("::::::::::::::::::::: DBConfig initialize..");
    }

    
    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer()
    {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new Resource[] { new ClassPathResource(APP_CONFIG_FILE_PATH) });
        return ppc;
    }
    
    @Bean
    public DataSource dataSource()
    {
        
        //BasicDataSource dataSource = new BasicDataSource();
        /*dataSource.setDriverClassName(this.jdbcDriverClassName);
        dataSource.setUrl(this.jdbcUrl);*/
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(this.jdbcDriverClassName);
        dataSource.setJdbcUrl(this.jdbcUrl);
        dataSource.setUsername(this.jdbcUsername);
        dataSource.setPassword(this.jdbcPassword);
        return dataSource;
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        
       SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
       sessionFactory.setDataSource(dataSource());
       //sessionFactory.setMapperLocations(applicationContext.getResources("classpath:/config/sql/*.xml"));
       return sessionFactory.getObject();
    }
}
