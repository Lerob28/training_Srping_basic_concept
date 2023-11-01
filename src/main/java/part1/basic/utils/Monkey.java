package part1.basic.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Monkey {

    @Value("my_monkey")
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        this.setName("King-Kong");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
