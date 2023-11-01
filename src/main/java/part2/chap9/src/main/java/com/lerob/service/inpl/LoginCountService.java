package com.lerob.service.inpl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCountService {
    private int count;

    public void increment() {
       this.setCount();
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        count++;
    }
}
