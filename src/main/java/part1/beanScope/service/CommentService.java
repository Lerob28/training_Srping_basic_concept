package part1.beanScope.service;

import part1.beanScope.repository.impl.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;


//@Service
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@Lazy
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
        System.out.println("Comment service instance created ...");
    }


    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

    @Override
    public String toString() {
      return "CommentService : { }";
    }
}
