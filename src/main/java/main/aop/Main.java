package main.aop;

import main.aop.config.aopConfig;
import main.aop.model.Comment;
import main.aop.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(aopConfig.class);
        CommentService service = ctx.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Lerob28");
        comment.setText("some borring comment i want to make here ...");

        service.publishComment(comment);
    }
}
