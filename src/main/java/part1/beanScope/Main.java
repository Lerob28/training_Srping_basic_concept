package part1.beanScope;

import part1.beanScope.config.ProjectConfig;
import part1.beanScope.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    /*public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println("Before retrieving the comment service ...");
        CommentService srv = ctx.getBean(CommentService.class);
        System.out.println("After retrieving the comment service ...");

       /* CommentService srv1 = ctx.getBean("commentService", CommentService.class);
        UserService srv2    = ctx.getBean("userService", UserService.class);

        boolean sameRepository = srv1.getCommentRepository().equals(srv2.getCommentRepository());

        System.out.println(sameRepository);// \*

    }*/

   public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService srv1 = ctx.getBean("commentService", CommentService.class);
        CommentService srv2 = ctx.getBean("commentService", CommentService.class);

        boolean sameService = srv1.equals(srv2);

        System.out.println(sameService);

    }
}
