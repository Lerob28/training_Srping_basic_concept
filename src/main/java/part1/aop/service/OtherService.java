package part1.aop.service;

import part1.aop.model.Comment;
import part1.aop.utils.Tolog;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OtherService {
    private final Logger logger = Logger.getLogger(OtherService.class.getName());

    public void publishComment(Comment comment) {
        logger.info("Publishing comment : "+ comment.getText()+" by "+comment.getAuthor());
    }

    @Tolog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment : "+ comment.getText()+" by "+comment.getAuthor());
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment : "+ comment.getText()+" by "+comment.getAuthor());
    }
}
