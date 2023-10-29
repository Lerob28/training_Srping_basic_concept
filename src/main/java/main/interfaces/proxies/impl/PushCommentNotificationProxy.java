package main.interfaces.proxies.impl;

import main.interfaces.model.Comment;
import main.interfaces.proxies.ICommentNotificationProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("push")
//@Primary
public class PushCommentNotificationProxy implements ICommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment: "+comment.getText());
    }
}
