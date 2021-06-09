package gabrielnardes.springwebmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebMvcApplication.class, args);
		System.out.println("Server on");
	}
}
