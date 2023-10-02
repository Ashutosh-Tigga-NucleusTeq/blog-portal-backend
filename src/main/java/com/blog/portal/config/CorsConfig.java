//This Configuration is used to control that which domains are allowed to access our APIs.
package com.blog.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    /**
     * Configures Cross-Origin Resource Sharing (CORS) for the application. This
     * method defines the allowed origins, methods, headers, and credentials for
     * CORS.
     *
     * @return WebMvcConfigurer instance with CORS configuration.
     */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new MyWebMvcConfigurer();
	}

	static class MyWebMvcConfigurer implements WebMvcConfigurer {
	    @Override
	    public void addCorsMappings(final CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:3000")
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	                .allowedHeaders("*")
	                .allowCredentials(true);
	    }
	}

}
