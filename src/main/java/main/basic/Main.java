package main.basic;

import main.basic.config.projectConfig;
import main.basic.utils.Birtd;
import main.basic.utils.Monkey;
import main.basic.utils.Parrot;
import main.basic.utils.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(projectConfig.class);

        Parrot p = ctx.getBean("parrot1",Parrot.class);
        Parrot p2 = (Parrot) ctx.getBean("parrot2");
        Parrot p3 = ctx.getBean("parrot3", Parrot.class);
        Monkey m = ctx.getBean(Monkey.class);

        String s = ctx.getBean(String.class);
        Integer i = ctx.getBean(Integer.class);

        System.out.println(p);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println();
        System.out.println("===================================");
        System.out.println("===================================");
        System.out.println();

        System.out.println(s);
        System.out.println(i);
        System.out.println(m.getName());


        Birtd b = new Birtd();
        b.setName("flyppi");
        Supplier<Birtd> birtdSupplier = () -> b;

        ctx.registerBean("birtd1", Birtd.class, birtdSupplier);

        Birtd b1 = ctx.getBean(Birtd.class);
        System.out.println(b1.getName());

        System.out.println();
        System.out.println("===================================");
        System.out.println("===================================");
        System.out.println();

        Person person = ctx.getBean(Person.class);
        System.out.println("Parrot's name : "+p.getName());
        System.out.println("Person's name : "+person.getName());
        System.out.println("Person's parrot : "+person.getParrot());
    }
}
