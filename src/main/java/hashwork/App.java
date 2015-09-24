package hashwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@Configuration
@EnableAutoConfiguration

public class App 
{
    public static void main(String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
