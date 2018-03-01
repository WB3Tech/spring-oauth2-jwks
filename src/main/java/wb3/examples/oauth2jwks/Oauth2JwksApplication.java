package wb3.examples.oauth2jwks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class Oauth2JwksApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2JwksApplication.class, args);
	}
	
}
