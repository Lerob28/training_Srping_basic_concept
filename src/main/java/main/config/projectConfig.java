package main.config;

import main.utils.Parrot;
import main.utils.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "main")
public class projectConfig {

    @Bean(value = "parrot1")
    @Primary
    Parrot parrot1(){
       Parrot parrot = new Parrot();
       parrot.setName("Koko");
       return parrot;
   }

  /* @Bean("person")
    Person person(@Qualifier("parrot3") Parrot parrot) {
        Person p = new Person();
        p.setName("Lerob");
        p.setParrot(parrot);
        //p.setParrot(parrot1());
        return p;
   }*/

   @Bean("parrot2")
   Parrot parrot2() {
        Parrot parrot =  new Parrot();
        parrot.setName("Kiki");
        return  parrot;
   }

   @Bean(name = "parrot3")
   Parrot parrot3() {
        Parrot parrot = new Parrot();
        parrot.setName("Riki");
        return parrot;
   }

   @Bean
    String hello() {
        return "Hello";
   }

   @Bean
    Integer ten() {
        return 10;
   }

}
