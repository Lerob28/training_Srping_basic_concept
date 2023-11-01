package part1.interfaces.repositories;

import part1.interfaces.model.Comment;

public interface ICommentRepository {
    void storeComment(Comment comment);
}
