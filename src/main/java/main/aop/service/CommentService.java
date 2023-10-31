package main.aop.service;

import main.aop.model.Comment;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class CommentService {

    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        logger.info("publishing comment : "+ comment.getText()+" by "+comment.getAuthor());
        return "SUCCESS";
    }
}
