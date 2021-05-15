package com.algaworks.brewer.config;


import javax.cache.Caching;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableCaching
@EnableAsync
public class WebConfig implements WebMvcConfigurer {
	
	
// configuração para forçar o idioma ser sempre português (accept-language no header da requisição)	
//	@Bean 
//	public LocaleResolver localeResolver() {
//		return new FixedLocaleResolver(new Locale("pt", "BR"));
//	}
	
	@Bean
	public CacheManager cacheManager() throws Exception {
		return new JCacheCacheManager(Caching.getCachingProvider().getCacheManager(
				getClass().getResource("/env/ehcache.xml").toURI(),
				getClass().getClassLoader()));
	}
	
//	@Bean
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
//		bundle.setBasename("classpath:/messages");
//		bundle.setDefaultEncoding("UTF-8"); // https://www.utf8-chartable.de/
//		return bundle;
//	}
	

}
