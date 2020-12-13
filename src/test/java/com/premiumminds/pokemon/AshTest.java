package com.premiumminds.pokemon;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.test.util.ReflectionTestUtils;

import java.util.LinkedList;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AshTest {

    private Ash ash;


    @BeforeEach
    public void setup() {
        ash = new Ash();
    }


    @Test
    public void moveWithEmptyString() {
        ash.move("");
        assertEquals(ash.getPokemonCounter(), 1);
    }

    @Test
    public void moveWithOtherCharacters() {
        ash.move("fggnNtghfgfh");
        assertEquals(ash.getPokemonCounter(), 3);
    }

    @Test
    public void moveExamples() {


        ash.move("E");
        assertEquals(ash.getPokemonCounter(), 2);
        ash = new Ash();

        ash.move("NESO");
        assertEquals(ash.getPokemonCounter(), 4);
        ash = new Ash();

        ash.move("NSNSNSNSNS");
        assertEquals(ash.getPokemonCounter(), 2);
    }


    @Test
    public void catchPokemonInNewPosition() {

        int initialPokemons = ash.getPokemonCounter();
        LinkedList<Position> positionsMock = mock(LinkedList.class);
        Position position = new Position(5, 5);

        ReflectionTestUtils.setField(ash, "pastPositions", positionsMock);
        when(positionsMock.contains(any())).thenReturn(false);

        ash.catchPokemon(position);

        verify(positionsMock, times(1)).add(any());
        assertNotEquals(ash.getPokemonCounter(), initialPokemons);
    }

    @Test
    public void catchPokemonInPreviousPosition() {

        int initialPokemons = ash.getPokemonCounter();
        LinkedList<Position> positionsMock = mock(LinkedList.class);
        Position position = new Position(5, 5);

        ReflectionTestUtils.setField(ash, "pastPositions", positionsMock);
        when(positionsMock.contains(any())).thenReturn(true);

        ash.catchPokemon(position);

        verify(positionsMock, times(1)).add(any());
        assertEquals(ash.getPokemonCounter(), initialPokemons);
    }
}