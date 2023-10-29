package main.interfaces.proxies;

import main.interfaces.model.Comment;

public interface ICommentNotificationProxy {
    void sendComment(Comment comment);
}
