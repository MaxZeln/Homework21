package ru.learnup.homework21;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.homework21.game.Guess_The_Number;


@SpringBootApplication
public class Homework21Application {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Homework21Application.class, args);

        Guess_The_Number guess_the_number = context.getBean(Guess_The_Number.class);
        guess_the_number.Guess();

    }
}
