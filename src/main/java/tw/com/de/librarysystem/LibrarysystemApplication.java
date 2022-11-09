package tw.com.de.librarysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LibrarysystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibrarysystemApplication.class, args);

	}
	
}
