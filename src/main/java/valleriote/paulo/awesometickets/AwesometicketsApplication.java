package valleriote.paulo.awesometickets;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableCaching
@EnableRabbit
@EnableJpaAuditing
public class AwesometicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwesometicketsApplication.class, args);
	}

}
