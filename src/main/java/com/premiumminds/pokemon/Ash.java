/**
 *  Ash Class
 *  Class used to move and catch pokemons for Ash;
 *  Has method move(), that takes a string with directions which moves ash N, S , E , O
 *  And for every position ash moves to, he checks if he can catch a new pokemon
 */

package com.premiumminds.pokemon;

import java.util.LinkedList;
import java.util.List;

public class Ash {

    private final int speed;
    private int pokemonCounter;
    private Position currentPosition;
    private List<Position> pastPositions;

    public Ash() {
        pokemonCounter = 1;
        speed = 1;
        currentPosition = new Position(0, 0);
        pastPositions = new LinkedList<>();
        pastPositions.add(new Position(currentPosition.getX(), currentPosition.getY()));
    }

    public int getPokemonCounter() {
        return pokemonCounter;
    }

    public void move(String movements) {

        movements.toUpperCase().chars().forEachOrdered(c -> {
                    switch (c) {
                        case 'N':
                            currentPosition.setY(currentPosition.getY() + speed);
                            break;
                        case 'S':
                            currentPosition.setY(currentPosition.getY() - speed);
                            break;
                        case 'E':
                            currentPosition.setX(currentPosition.getX() - speed);
                            break;
                        case 'O':
                            currentPosition.setX(currentPosition.getX() + speed);
                            break;
                        default:
                            break;
                    }
                    catchPokemon(currentPosition);
                }
        );
    }

    public void catchPokemon(Position position) {
        if (!pastPositions.contains(position)) {
            pastPositions.add(new Position(currentPosition.getX(), currentPosition.getY()));
            pokemonCounter++;
        }
    }

}
