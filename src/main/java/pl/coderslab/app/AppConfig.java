package pl.coderslab.app;

import java.util.Locale;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.SmartValidator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.coderslab.controller.IngredientGroupConverter;
import pl.coderslab.controller.UserGroupConverter;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "pl.coderslab")
@EnableJpaRepositories(basePackages = "pl.coderslab.repository")
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean(); 
		emfb.setPersistenceUnitName("PairingPersistenceUnit"); 
	return emfb;
	}
	
	@Bean
	public JpaTransactionManager transactionManager( EntityManagerFactory emf) {
	JpaTransactionManager tm = new JpaTransactionManager(emf);
	return tm; }
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public SmartValidator validator() {
	return new LocalValidatorFactoryBean(); }
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(getUserGroupConverter());
		registry.addConverter(getIngredientGroupConverter());
	}
	
	@Bean
	public UserGroupConverter getUserGroupConverter()
	{
		return new UserGroupConverter();
	}
	
	@Bean
	public IngredientGroupConverter getIngredientGroupConverter()
	{
		return new IngredientGroupConverter();
	}
	
	@Bean(name="localeResolver")
	public LocaleContextResolver getLocaleContextResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("pl","PL"));
		return localeResolver; 
	
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}
