package gabrielnardes.jaxrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JacksonBinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacksonBinderApplication.class, args);
		System.out.println("Server on");
	}
}
