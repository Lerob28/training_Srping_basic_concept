package main.beanScope.service;

import main.beanScope.repository.impl.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


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
