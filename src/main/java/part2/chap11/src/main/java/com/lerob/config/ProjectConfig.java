package part2.chap11.src.main.java.com.lerob.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients(basePackages = "com.lerob.proxy")
public class ProjectConfig {
}
