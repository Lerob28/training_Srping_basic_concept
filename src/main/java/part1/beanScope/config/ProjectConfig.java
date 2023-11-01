package part1.beanScope.config;


import part1.beanScope.repository.impl.CommentRepository;
import part1.beanScope.service.CommentService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "part1.beanScope")
public class ProjectConfig {

    private CommentRepository commentRepository;

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CommentService commentService() {
        return new CommentService(commentRepository);
    }

}
