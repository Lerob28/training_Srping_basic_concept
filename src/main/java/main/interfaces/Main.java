package main.interfaces;


import main.interfaces.proxies.ICommentNotificationProxy;
import main.interfaces.proxies.impl.EmailCommentNotificationProxy;
import main.interfaces.repositories.ICommentRepository;
import main.interfaces.repositories.impl.DB_CommentRepository;
import main.interfaces.model.Comment;
import main.interfaces.config.CustomConfig;
import main.interfaces.services.CommentService;
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

