package part1.interfaces;


import part1.interfaces.model.Comment;
import part1.interfaces.config.CustomConfig;
import part1.interfaces.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CustomConfig.class);

        Comment comment = new Comment();
        comment.setAuthor("Lerob28");
        comment.setText("I Really appreciate this book");

        CommentService commentService = ctx.getBean(CommentService.class);
        commentService.publishComment(comment);
    }

    /*public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("Lerob28");
        comment.setText("I Really appreciate this book");

        ICommentRepository dbCommentRepository = new DB_CommentRepository();
        ICommentNotificationProxy emailCommentNotificationProxy = new EmailCommentNotificationProxy();

        CommentService commentService = new CommentService(dbCommentRepository, emailCommentNotificationProxy);

        commentService.publishComment(comment);
    }*/

}

