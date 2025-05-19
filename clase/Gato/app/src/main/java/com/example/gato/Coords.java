package com.example.gato;

public class Coords{

    private int currentXVal;
    private int currentYVal;

    public int getCurrentXVal() {

        return currentXVal;

    }

    public int getCurrentYVal(){

        return currentYVal;

    }

    public void setCurrentXVal(int currentXVal) {

        this.currentXVal = currentXVal;

    }

    public void setCurrentYVal(int currentYVal) {

        this.currentYVal = currentYVal;

    }

    public int[][] getCurrentPositionMatrix() {

        return new int[currentXVal][currentYVal];

    }

    public void setCurrentPosition(int xVal, int yVal) {

        setCurrentXVal(xVal);
        setCurrentYVal(yVal);

    }


}
