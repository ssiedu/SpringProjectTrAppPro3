package com.ssi.config;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages="com.ssi")
public class DemoAppConfig implements WebMvcConfigurer  {


	//<mvc:resources mapping="/resources/**" location="/resources/" /> (dispatcher-servlet)
	/*
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry
         .addResourceHandler("/resources/**")
         .addResourceLocations("/resources/"); 
	}*/

	 	//alternative for Internal View Resolver
	   public void configureViewResolvers(ViewResolverRegistry registry) {
	      registry.jsp("/WEB-INF/views/", ".jsp");
	   }

	   public void addResourceHandlers(ResourceHandlerRegistry registry) {

		      
		      // Register resource handler for images
		      registry
		      .addResourceHandler("/images/**")
		      .addResourceLocations("/WEB-INF/images/");
		      
		     // Register resource hanlder for css
		      
		      registry
		      .addResourceHandler("/css/**")
		      .addResourceLocations("/WEB-INF/css/");
		            
		   }
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan("com.ssi.entities");
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql","true");
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
	}
	
	@Bean
	public  ComboPooledDataSource myDataSource() {
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		try {
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/springdata");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		}catch(Exception e) {}
		return dataSource;
	}
	
}
