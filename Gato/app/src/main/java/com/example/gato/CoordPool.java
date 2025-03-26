package com.example.gato;

import java.util.*;

public class CoordPool {

    private final List<int[]> coordPool;

    public CoordPool() {
        this.coordPool = Arrays.asList(
                new int[]{1, 1}, new int[]{1, 2}, new int[]{1, 3},
                new int[]{2, 1}, new int[]{2, 2}, new int[]{2, 3},
                new int[]{3, 1}, new int[]{3, 2}, new int[]{3, 3}
        );
    }

    public List<int[]> getCoordPool() {
        return coordPool;
    }

}