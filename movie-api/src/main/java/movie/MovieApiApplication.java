package movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;


@EnableFeignClients
@SpringBootApplication
public class MovieApiApplication {

	@GetMapping
	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);
	}

}
