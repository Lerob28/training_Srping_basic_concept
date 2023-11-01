package part1.interfaces.proxies;

import part1.interfaces.model.Comment;

public interface ICommentNotificationProxy {
    void sendComment(Comment comment);
}
