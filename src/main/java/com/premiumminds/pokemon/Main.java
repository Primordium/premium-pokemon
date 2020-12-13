package com.premiumminds.pokemon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ash ash = new Ash();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a string of Movements");
        ash.move(scanner.nextLine());
        System.out.println("Ash caught " + ash.getPokemonCounter() + " pokemons");

    }
}
