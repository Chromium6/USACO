package main;

import bodies.Boid;
import java.util.*;

public class Grid {
    public int n, unit; // size (square)
    public List<List<Boid>> map; // track boids in their own area to optimize exe time

    public Grid(int size, int gridN) { // size = side length, gridN = number of grids per side (gridN x gridN)
        n = gridN;
        unit = size/gridN;
        map = new ArrayList<>();
        for (int i = 0; i < n*n; i ++) {
            map.add(new ArrayList<Boid>());
        }
    }

    public int getSideLength() {
        return n*unit;
    }

    public int flatten(int x, int y) {
        return y*n+x;
    }
}
