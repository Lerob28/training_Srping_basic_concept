package main.beanScope.config;


import main.beanScope.repository.impl.CommentRepository;
import main.beanScope.service.CommentService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "main.beanScope")
public class ProjectConfig {

    private CommentRepository commentRepository;

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CommentService commentService() {
        return new CommentService(commentRepository);
    }

}
