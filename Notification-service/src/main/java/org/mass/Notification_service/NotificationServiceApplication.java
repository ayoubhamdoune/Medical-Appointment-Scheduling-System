package org.mass.Notification_service;

import org.mass.Notification_service.entities.Notification;
import org.mass.Notification_service.repository.NotificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(NotificationRepository NotificationRepository, RepositoryRestConfiguration RestConfiguration){
		return args -> {
			RestConfiguration.exposeIdsFor(Notification.class);

		};
	};
}
