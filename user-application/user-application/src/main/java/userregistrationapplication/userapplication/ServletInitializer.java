package userregistrationapplication.userapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "userregistrationapplication.userapplication")
public class ServletInitializer extends SpringBootServletInitializer {

	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources( UserApplication.class);
	    }

	    public static void main(String[] args) {
	    	SpringApplication.run( UserApplication.class);
	    }
	
}
