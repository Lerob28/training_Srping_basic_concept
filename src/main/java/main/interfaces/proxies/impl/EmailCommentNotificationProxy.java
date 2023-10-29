package main.interfaces.proxies.impl;

import main.interfaces.model.Comment;
import main.interfaces.proxies.ICommentNotificationProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("email")
public class EmailCommentNotificationProxy implements ICommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending Email notification for comment: "+comment.getText());
    }
}
