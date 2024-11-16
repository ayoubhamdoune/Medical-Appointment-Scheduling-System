package org.mass.Notification_service;

import org.mass.Notification_service.entities.Notification;
import org.mass.Notification_service.repository.NotificationRepository;
import org.mass.Notification_service.services.NotificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableFeignClients
public class NotificationServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(NotificationRepository notificationRepository, RepositoryRestConfiguration RestConfiguration){
		return args -> {
			RestConfiguration.exposeIdsFor(Notification.class);
			Notification notification = new Notification();
			notification.setRecipientId(1L);
			notification.setMessage("main");
			notificationRepository.save(notification);


		};
	};
}
