package com.premium.minds.pokemon.util;

/**
 *  Position Class
 *  Class used to map position of Ash in a bi-dimensional grid with X and Y cords
 */

public class Position {

    private int xPos;
    private int yPos;

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void updatePosition(Direction direction) {
        xPos += direction.getxDirection();
        yPos += direction.getyDirection();
    }

    @Override
    public boolean equals(Object o) {

        return o instanceof Position && (((Position) o).xPos == xPos)
                && (((Position) o).yPos == yPos);
    }

    @Override
    public String toString() {
        return "Position{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                '}';
    }

}
