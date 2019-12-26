package xmu.oomall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaClient
public class OomallApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(OomallApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
