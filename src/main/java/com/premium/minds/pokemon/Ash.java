
package com.premium.minds.pokemon;

/**
 * Ash Class
 * Class used to move and catch pokemons for Ash;
 * Has method move(), that takes a string with directions which moves ash N, S , E , O
 * And for every position ash moves to, he checks if he can catch a new pokemon
 */

import com.premium.minds.pokemon.util.Direction;
import com.premium.minds.pokemon.util.Position;

import java.util.LinkedList;
import java.util.List;

public class Ash {

    private int pokemonCounter;
    private Position currentPosition;
    private List<Position> pastPositions;

    public Ash() {
        pokemonCounter = 0;
        currentPosition = new Position(0, 0);
        pastPositions = new LinkedList<>();
        catchPokemon(currentPosition);
    }

    public int getPokemonCounter() {
        return pokemonCounter;
    }

    public void move(String movements) {

        movements.toUpperCase().chars().forEachOrdered(c -> {

                    switch (c) {
                        case 'S':
                        case 'N':
                            currentPosition.setY(currentPosition.getY() + (Direction.valueOf(Character.toString(c)).getyDirection()));
                            break;
                        case 'E':
                        case 'O':
                            currentPosition.setX(currentPosition.getX() + (Direction.valueOf(Character.toString(c)).getxDirection()));
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
