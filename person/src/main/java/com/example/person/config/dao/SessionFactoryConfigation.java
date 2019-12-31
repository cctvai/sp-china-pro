package com.example.person.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SessionFactoryConfigation {
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    @Value("${mapper_path}")
    private String mapeerPath;
    @Value("${entity_package}")
    private String entityPackage;
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean creatSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSerachPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                + mapeerPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSerachPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }

}
