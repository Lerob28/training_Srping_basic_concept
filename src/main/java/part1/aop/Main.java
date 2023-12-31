package part1.aop;

import part1.aop.config.aopConfig;
import part1.aop.model.Comment;
import part1.aop.service.CommentService;
import part1.aop.service.OtherService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(aopConfig.class);

        CommentService service = ctx.getBean(CommentService.class);
        OtherService otherService = ctx.getBean(OtherService.class);

        Comment comment = new Comment();
        comment.setAuthor("Lerob28");
        comment.setText("some boring comment i want to make here ...");

        //String result = service.publishComment(comment);

        //otherService.publishComment(comment);
        //otherService.editComment(comment);
        otherService.deleteComment(comment);

        //logger.info(result);
    }
}
