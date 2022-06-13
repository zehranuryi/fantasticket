package com.codecrew.fantasticket;

import com.codecrew.fantasticket.enums.EventSubType;
import com.codecrew.fantasticket.enums.EventType;
import com.codecrew.fantasticket.enums.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FantasticketApplication {
	public static void main(String[] args) {
		SpringApplication.run(FantasticketApplication.class, args);
	}
	
	
	@Configuration
	public class WebConfig implements WebMvcConfigurer {
		@Override
		public void addFormatters(FormatterRegistry registry) {
			registry.addConverter(new EventStringToEnumConverter());
			registry.addConverter(new EventSubStringToEnumConverter());
			registry.addConverter(new RoleStringToEnumConverter());
		}
	}
	
	public class EventStringToEnumConverter implements Converter<String, EventType> {
		@Override
		public EventType convert(String source) {
			return EventType.valueOf(source.toUpperCase());
		}
	}
	
	public class EventSubStringToEnumConverter implements Converter<String, EventSubType> {
		@Override
		public EventSubType convert(String source) {
			return EventSubType.valueOf(source.toUpperCase());
		}
	}
	
	public class RoleStringToEnumConverter implements Converter<String, Role> {
		@Override
		public Role convert(String source) {
			return Role.valueOf(source.toUpperCase());
		}
	}
}