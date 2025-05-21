package com.example.m6_01;

public class Avion {

    private int posX;
    private int posY;
    private Direction direction;
    private boolean isCollided;
    private boolean isAtDestination = false;

    public Avion(int posX, int posY, Direction direction) {

        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
        this.isCollided = false;

    }

    public void mover(int columns, int rows) {

        if (!isCollided) {

            switch (direction) {
                case NORTH: if (posY > 0) posY--; break;
                case SOUTH: if (posY < rows - 1) posY++; break;
                case EAST: if (posX < columns - 1) posX++; break;
                case WEST: if (posX > 0) posX--; break;
            }

        }

    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isCollided() {
        return isCollided;
    }

    public void setCollided(boolean collided) {
        isCollided = collided;
    }

    public void setAtDestination(boolean atDestination) {
        isAtDestination = atDestination;
    }
    public boolean isAtDestination() {
        return isAtDestination;
    }

    public boolean isAtBorder(int columns, int rows) {

        switch (direction) {

            case NORTH:
                return posY == 0;
            case SOUTH:
                return posY == rows - 1;
            case EAST:
                return posX == columns - 1;
            case WEST:
                return posX == 0;
            default:
                return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Avion avion = (Avion) obj;
        return posX == avion.posX && posY == avion.posY && direction == avion.direction;
    }

    @Override
    public int hashCode() {
        int result = posX;
        result = 31 * result + posY;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }

    public enum Direction { NORTH, SOUTH, EAST, WEST }

}
