package tanktrouble;

import org.jbox2d.common.Vec2;

public class Cell {
	Cell parent; // which cell robot came from to this cell
	Pair loc; // location of Cell
	float f, g, h; // A* parameters
				   // f = g (cost to this) + h (heurustic cost to target)
	private int id; // optional id
	
	public Cell(Cell Parent, int ix, int iy) {
		parent = Parent;
		loc = new Pair(ix, iy);
	}
	
	public Cell(Cell Parent, Vec2 source ) {
		parent = Parent;
		loc = new Pair(source);
	}
	
	public int x() { return loc.x; }
	public int y() { return loc.y; }
	public void setID(int val) { id = val; }
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
	
	public Pair(Vec2 source) {
		x = (int)source.x;
		y = (int)source.y;
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