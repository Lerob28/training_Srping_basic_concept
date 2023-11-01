package part1.interfaces.proxies.impl;

import part1.interfaces.model.Comment;
import part1.interfaces.proxies.ICommentNotificationProxy;
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
