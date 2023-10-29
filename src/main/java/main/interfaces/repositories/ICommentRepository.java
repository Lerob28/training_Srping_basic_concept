package main.interfaces.repositories;

import main.interfaces.model.Comment;

public interface ICommentRepository {
    void storeComment(Comment comment);
}
