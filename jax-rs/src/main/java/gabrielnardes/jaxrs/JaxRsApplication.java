package gabrielnardes.jaxrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JaxRsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaxRsApplication.class, args);
		System.out.println("Server on");
	}
}
