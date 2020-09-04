
package acme.com.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("acme.com")
public class WebMvcConfig implements WebMvcConfigurer{

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource() {
		
		ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
		
		reloadableResourceBundleMessageSource.setBasename("classpath:messages");
		reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
		
		return reloadableResourceBundleMessageSource;
	}

	@Bean(name = "localeResolver")
	public CookieLocaleResolver localeResolver() {
		
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		
		Locale ld = Locale.ENGLISH;
		cookieLocaleResolver.setDefaultLocale(ld);
		cookieLocaleResolver.setCookieName("myAppLocaleLang");
		cookieLocaleResolver.setCookieMaxAge(3600);
		
		return cookieLocaleResolver;
	}
	
	@Bean(name = "localeChangeInterceptor")
	public LocaleChangeInterceptor localeChangeInterceptor() {
		
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		
		localeChangeInterceptor.setParamName("locale");
		
		return localeChangeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}
