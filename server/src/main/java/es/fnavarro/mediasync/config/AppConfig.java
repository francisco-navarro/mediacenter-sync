package es.fnavarro.mediasync.config;  

import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import es.fnavarro.mediasync.controllers.BaseController;

@Configuration
@ComponentScan(basePackageClasses = {BaseController.class}) 


@EnableWebMvc
public class AppConfig extends WebMvcConfigurationSupport {
	
	private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {

		RequestMappingHandlerMapping handlerMapping = super.requestMappingHandlerMapping();
		return handlerMapping;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(converter());
		addDefaultHttpMessageConverters(converters);
	}

	@Bean
	MappingJackson2HttpMessageConverter converter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		return converter;
	}  
	

	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:file:~/mediaDB");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	    return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("es.fnavarro.mediasync.resources");
        sessionFactory.setMapperLocations(resourcePatternResolver.getResources("classpath:es/fnavarro/mediasync/mapper/*Mapper.xml"));
		return sessionFactory;
	}


}

