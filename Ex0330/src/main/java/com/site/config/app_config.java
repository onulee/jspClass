package com.site.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

// Mybatis 사용할수 있도록 연결
@Configuration
public class app_config {
	
	//dataSource Mybatis연결 
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	sessionFactory.setDataSource(dataSource);

	Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**/*.xml");
	sessionFactory.setMapperLocations(res);

	return sessionFactory.getObject();
	}

	// Mybatis 생성
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
	System.out.println("sqlSessionFactory : " + sqlSessionFactory);
	return new SqlSessionTemplate(sqlSessionFactory);
	}

}
