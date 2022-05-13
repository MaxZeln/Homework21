package ru.learnup.homework21.game;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.learnup.homework21.annotation.LogMethod;
import ru.learnup.homework21.annotation.WorkTime;
import ru.learnup.homework21.translations.Resource;

import java.util.Locale;

@Service
@Data
public class Guess_The_Number {
    private final Randomizer rand;
    private final Guess_Scanner scanner;
    private final Resource resource;

    public Guess_The_Number(Randomizer rand, Guess_Scanner scanner,Resource resource) {
        this.rand = rand;
        this.scanner = scanner;
        this.resource = resource;
    }

    @LogMethod
    @WorkTime
    public void Guess() {
        System.out.println("Правильный ответ, для проверки работы программы: " + rand.getRand());
        System.out.println();


        System.out.println(resource.getResource().getMessage("startGame", null, Locale.getDefault()));
        System.out.println(resource.getResource().getMessage("startGame", null, Locale.US));
        System.out.println();
        System.out.println(resource.getResource().getMessage("startGame2", null, Locale.getDefault()));
        System.out.println(resource.getResource().getMessage("startGame2", null, Locale.US));
        System.out.println();
        System.out.println(resource.getResource().getMessage("exitGame", null, Locale.getDefault()));
        System.out.println(resource.getResource().getMessage("exitGame", null, Locale.US));

        while(true) {

            int guess = scanner.getScanner().nextInt();

            if (guess == -1) {
                System.out.println(resource.getResource().getMessage("exitGame2", null, Locale.getDefault()));
                System.out.println(resource.getResource().getMessage("exitGame2", null, Locale.US));

                System.out.println(resource.getResource().getMessage("exitGame3", null, Locale.getDefault()) + " " + rand.getRand());
                System.out.println(resource.getResource().getMessage("exitGame3", null, Locale.US) + " " + rand.getRand());
                break;
            }
            else if (rand.getRand() == guess) {
                System.out.println(resource.getResource().getMessage("numberGuessedRight", null, Locale.getDefault()) + " " + rand.getRand());
                System.out.println(resource.getResource().getMessage("numberGuessedRight", null, Locale.US) + " " + rand.getRand());
                break;
            }
            else if (rand.getRand() > guess) {
                System.out.println(resource.getResource().getMessage("numberBigger", null, Locale.getDefault()));
                System.out.println(resource.getResource().getMessage("numberBigger", null, Locale.US));
            }
            else if (rand.getRand() < guess) {
                System.out.println(resource.getResource().getMessage("numberLess", null, Locale.getDefault()));
                System.out.println(resource.getResource().getMessage("numberLess", null, Locale.US));

            }

        }

    }

}
