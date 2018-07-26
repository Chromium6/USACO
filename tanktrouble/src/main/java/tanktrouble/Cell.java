package tanktrouble;

import java.util.Comparator;

public class Cell implements Comparator<Cell> {
	Cell parent; // which cell robot came from to this cell
	Pair loc; // location of Cell
	int val;
	double f, g, h; // A* parameters
				   // f = g (cost to this) + h (heurustic cost to target)
	private int id; // optional id
	
	public Cell(Cell Parent, int ix, int iy) {
		parent = Parent;
		loc = new Pair(ix, iy);
	}
	
	public Cell(Cell Parent, Pair source ) {
		parent = Parent;
		loc = new Pair(source);
	}
	
	public Cell(int val) { this.val = val; }
	
	public int x() { return loc.x; }
	public int y() { return loc.y; }
	public void setID(int val) { id = val; }

	@Override
	public int compare(Cell arg0, Cell arg1) {
		/* Dijsktras comparison */
		if (arg0.f > arg1.f) return 1;
		return (arg0.f == arg1.f ? 0 : -1);
	}
	
	@Override
	public String toString() {
		return String.format("{%s, %s = %s + %s}", val, f, g, h);
	}
}

class Pair {
	// allow for 3D, but mostly used for 2D
	int x, y, z;
	
	public Pair(int ... coord) {
		x = coord[0];
		y = coord[1];
		z = 0;
		if (coord.length >= 3) z = coord[2];
	}
	
	/*
	public Pair(Vec2 source) {
		x = (int)source.x;
		y = (int)source.y;
	}*/
	
	public Pair(Pair source) {
		this.x = source.x;
		this.y = source.y;
	}
	
	public Pair add(int dx, int dy) {
		return new Pair(this.x+dx, this.y+dy);
	}
	
	public Pair add(Pair d) {
		return new Pair(this.x + d.x, this.y + d.y);
	}
	
	public boolean isValid(int min, int max) {
		return (this.x >= min && this.x < max) && (this.y >= min && this.y < max);
	}
 }