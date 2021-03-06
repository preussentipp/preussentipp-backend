package de.hoffmato.preussentipp.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * Thymeleaf and Spring MVC configuration.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "de.hoffmato.preussentipp.controller", "de.hoffmato.preussentipp.rest", "de.hoffmato.preussentipp.service" })
public class SpringConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

	private static final String UTF8 = "UTF-8";

	private ApplicationContext applicationContext;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		// resolver.setTemplateEngine(templateEngine());
		// resolver.setCharacterEncoding(UTF8);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".html");
		return resolver;
	}

	// private TemplateEngine templateEngine() {
	// SpringTemplateEngine engine = new SpringTemplateEngine();
	// engine.setTemplateResolver(templateResolver());
	// return engine;
	// }
	//
	// private ITemplateResolver templateResolver() {
	// SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
	// resolver.setApplicationContext(applicationContext);
	// resolver.setPrefix("/WEB-INF/pages/");
	// resolver.setTemplateMode(TemplateMode.HTML);
	// return resolver;
	// }

}
