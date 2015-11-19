package es.fnavarro.mediasync.config;  

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import es.fnavarro.mediasync.controllers.BaseController;
import es.fnavarro.mediasync.mappers.MapperBase;

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
		DataSource dataSource = getDatasource();
		return dataSource;
	}

	private DataSource getDatasource() {
		String resource = "jdbc/mediasync";
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			return (DataSource)envContext.lookup(resource);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setTypeAliasesPackage("es.sugarsoft.commodities.resources");
		sessionFactory.setMapperLocations(resourcePatternResolver.getResources("classpath:es/sugarsoft/commodities/resources/persistence/*Mapper.xml"));
		return sessionFactory;
	}


}

