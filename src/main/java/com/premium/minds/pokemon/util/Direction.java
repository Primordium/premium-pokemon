package com.premium.minds.pokemon.util;

public enum Direction {
    N(0,1),
    S(0,-1),
    E(-1,0),
    O(1,0);

    private int xDirection;
    private int yDirection;
    Direction(int xDirection, int yDirection) {
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public int getxDirection() {
        return xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }
}
