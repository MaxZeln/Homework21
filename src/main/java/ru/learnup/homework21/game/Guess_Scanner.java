package ru.learnup.homework21.game;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Data
public class Guess_Scanner {

    private Scanner scanner = new Scanner(System.in);

}
