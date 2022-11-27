package com.nhnacademy.jdbc.board.config;

import com.nhnacademy.jdbc.board.mapper.MapperBase;
import com.p6spy.engine.spy.P6DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan(
        basePackageClasses = MapperBase.class,
        annotationClass = Mapper.class)
public class MybatisConfig {
    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        basicDataSource.setUrl("jdbc:mysql://133.186.151.141:3306/nhn_academy_32");
        basicDataSource.setUsername("nhn_academy_32");
        basicDataSource.setPassword("EJdrW!(bf]HjT9a5");
        basicDataSource.setInitialSize(2);
        basicDataSource.setMaxTotal(10);
        return basicDataSource;
    }

    @Bean
    public DataSource logDataSource(){
        return new P6DataSource(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/maps/*.xml"));
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(logDataSource());
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
