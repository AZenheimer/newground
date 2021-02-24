package newground.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "newground.app")
@SpringBootApplication
public class NewGroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewGroundApplication.class, args);
	}

}
