package part1.interfaces.repositories.impl;

import part1.interfaces.model.Comment;
import part1.interfaces.repositories.ICommentRepository;
import org.springframework.stereotype.Repository;


@Repository
public class DB_CommentRepository implements ICommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment in DataBase: " + comment.getText());
    }
}
