package com.premiumminds.pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testPositionEqualsShouldReturnTrue() {

        int xPos = 10;
        int yPos = 10;

        Position position1 = new Position(xPos, yPos);
        Position position2 = new Position(xPos, yPos);

        assertEquals(position1.getX(), position2.getX());
        assertEquals(position1.getY(), position2.getY());

        assertTrue(position1.equals(position2));
    }

    @Test
    void testPositionEqualsShouldReturnFalse() {

        int xPos = 10;
        int yPos = 10;

        int secondXPos = 5;
        int secondYPos = 5;

        Position position1 = new Position(xPos, yPos);
        Position position2 = new Position(secondXPos, secondYPos);

        assertNotEquals(position1.getX(), position2.getX());
        assertNotEquals(position1.getY(), position2.getY());

        assertFalse(position1.equals(position2));
    }
}