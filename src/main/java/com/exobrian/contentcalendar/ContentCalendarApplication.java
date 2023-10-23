package com.exobrian.contentcalendar;

import com.exobrian.contentcalendar.config.ContentCalendarProperties;
import com.exobrian.contentcalendar.model.Content;
import com.exobrian.contentcalendar.model.Status;
import com.exobrian.contentcalendar.model.Type;
import com.exobrian.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ContentCalendarApplication.class, args);
		Arrays.stream(context.getBeanDefinitionNames()).forEach(b -> System.out.println(b));
	}

//	@Bean
//	CommandLineRunner commandLineRunner(ContentRepository repository) {
//		return args -> {
//			System.out.println("Hello 🌍🌍 from the main method! Let's load in some data here.");
//			Content content = new Content(null,
//					"Twins",
//					"Another favorite movie of mine",
//					Status.IDEA,
//					Type.VIDEO,
//					LocalDateTime.now(),
//					null,
//					"");
//			repository.save(content);
//		};
//	}


}
