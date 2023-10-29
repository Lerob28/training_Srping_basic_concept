package main.interfaces.services;

import main.interfaces.model.Comment;
import main.interfaces.proxies.ICommentNotificationProxy;
import main.interfaces.repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class CommentService {
    private final ICommentRepository commentRepository;
    private final ICommentNotificationProxy commentNotificationProxy;

    public CommentService(
        ICommentRepository commentRepository,
        @Qualifier("push") ICommentNotificationProxy commentNotificationProxy)
    {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }


    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
