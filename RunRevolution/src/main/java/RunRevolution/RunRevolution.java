package RunRevolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RunRevolution {
    public static void main(String[] args) {
        SpringApplication.run(RunRevolution.class, args);
    }
}
