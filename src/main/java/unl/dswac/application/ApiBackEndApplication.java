package unl.dswac.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
public class ApiBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBackEndApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
//				registry.addMapping("/producto/**").allowedOrigins("http://localhost:4200")
//						.allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*");
			}
//	                public void addCorsMappings(CorsRegistry registry) {
//	                        registry.addMapping(“/producto/**”)
//	                                .allowedOrigins(“http://localhost:9001”)
//	                                .allowedMethods(“GET”, “POST”, “PUT”, “DELETE”)
//	                                .maxAge(3600);
//	                }

		};
	}

}
