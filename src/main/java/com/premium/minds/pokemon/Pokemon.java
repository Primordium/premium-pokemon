package com.premium.minds.pokemon;

import java.util.Scanner;

public class Pokemon {

    public static void main(String[] args) {
        Ash ash = new Ash();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input a string of Movements");
        String input = scanner.nextLine();

        ash.move(input);

        System.out.println(ash.getPokemonCounter());

    }
}
