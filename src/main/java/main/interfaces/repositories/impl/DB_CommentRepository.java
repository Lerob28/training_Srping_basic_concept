package main.interfaces.repositories.impl;

import main.interfaces.model.Comment;
import main.interfaces.repositories.ICommentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class DB_CommentRepository implements ICommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment in DataBase: " + comment.getText());
    }
}
