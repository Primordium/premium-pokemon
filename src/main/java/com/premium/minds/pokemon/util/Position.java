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

    public void setX(int xPos) {
        this.xPos = xPos;
    }

    public void setY(int yPos) {
        this.yPos = yPos;
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
