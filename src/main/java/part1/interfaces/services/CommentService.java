package part1.interfaces.services;

import part1.interfaces.model.Comment;
import part1.interfaces.proxies.ICommentNotificationProxy;
import part1.interfaces.repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
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
