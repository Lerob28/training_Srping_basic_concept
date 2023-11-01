package part1.aop.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "part1.aop")
@EnableAspectJAutoProxy
public class aopConfig {

}
