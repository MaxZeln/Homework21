package ru.learnup.homework21.game;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Data
public class Randomizer {

    int min = 0;
    int max = 1000;

    private int rand = new Random().nextInt(max - min) + min;

}