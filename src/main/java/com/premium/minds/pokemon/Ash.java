
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

    private Position currentPosition;
    private List<Position> pastPositions;

    public Ash() {
        currentPosition = new Position(0, 0);
        pastPositions = new LinkedList<>();
        catchPokemon(currentPosition);
    }

    public int getPokemonCounter() {
        return pastPositions.size();
    }

    public void move(String movements) {

        movements.toUpperCase().chars().filter(e -> (e == 'S' || e == 'N' || e == 'E' || e == 'O')).forEachOrdered(c ->
                {
                    currentPosition.updatePosition(Direction.valueOf(Character.toString(c)));
                    catchPokemon(currentPosition);
                }
        );
    }

    public void catchPokemon(Position position) {

        if (!pastPositions.contains(position)) {
            pastPositions.add(new Position(currentPosition.getX(), currentPosition.getY()));
        }
    }

}
