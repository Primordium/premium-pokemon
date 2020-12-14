package com.premium.minds.pokemon;

import com.premium.minds.pokemon.util.Position;
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
    public void longInput() {
        int secondInMilliseconds = 1000;
        long startTime = System.nanoTime();
        ash.move("zDNcNln3AUywsRiGmBpvv7HGRpmkNVsdRGdsVdVYBa7Q5mEq5jY2FczAudPPv1CG7CAh0dxS16XMnk6GXtp" +
                "r54usN0fCYVMym6b8iggvvPugnF8Nirl5SXkLj55u66I9dsg59yu2JDAxilTHYfquEqXQbtzrYMdBNr32b2UKYvwgy0I8G4f0" +
                "PiMnPfpgjLCASR9iUMxKS5VANruWKxm53S20A2zyeL1zvh3jXe6OBdXNRwIcIh9rRyY80Gc9CFG9aW0onACWR1v5ySQRISKefu" +
                "oxXXoVvf8ag7H4q4NkWibveE8Zmy8a6hYXPjhSxclZofeIg2FvOUZAUeciIJyJqZeMmJdWLfSUy76rdIxv4NR9b1U91OT44MiW" +
                "iZWvizAevWlY69WQkX3PDitoWtMCty58nt3WWVYjbgIvtnB0flJtOqs6AwNHpnsdCLFxzARHNhWIigIF1GFdKFdHLJLtWMUq8" +
                "2bzEnasOIQAg9xUSw4cLUyfAZBj1SZeV7jdMI6O1GT519YRQIPSfHBqSEzB4ejV8zy7hinKHbeL0sgST6Xxby15fpcKdhhwku8" +
                "gEkjVMeN8ZZmZ2F8AoXxeOGE6UKl4yK9SbJRIvn58hmDfqIE4jILge7xhTbQ3Jrusha1yHl9j3jeKraBnEMLkn4w4pYOYcrUSv" +
                "r8bfcOuaF8sFjdSzNVEsZYhj2XRCYvemTcN1DTXXTngIzmQjbX2zsuDTkNUvKn8CjEojtfNIiMbHaKRWHZ8cx6dJw92BXXTDRfY" +
                "Suka8ycLh8YBgopSToz37aeIt5MZroKTbxC9RPwuVhCryikjt0O7yTJu9AhKyYlRlaBParf4KpcILPywTd1Q5n2taXQqcglqJY0" +
                "LKzJMj9OTzHFngvdXHc4DpPy5oJoxaLC4ZWofs06UbKEUpzpuLszl1VAudflDsqIMJaHBEWOUM2hNWTrOdBanqnEoDWYkdQA7oek" +
                "TOXuu0mMeq8AGiP8lFyyYrMyC8Pmz8bCp");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        assertTrue(duration < secondInMilliseconds);
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
        verify(positionsMock, times(0)).add(any());
        assertEquals(ash.getPokemonCounter(), initialPokemons);
    }
}