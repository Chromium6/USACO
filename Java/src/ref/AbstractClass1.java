package ref;

public class AbstractClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/* Abstract classes define a general framework for subclasses without specifying details
 * */
abstract class Polygon2D {
	private int[] sideLengths;
	private float area;
	
	/* Abstract classes can define an abstract
	 * */
	public Polygon2D() {
		sideLengths = new int[]{0, 0, 0};
	}
	
	/* Abstract methods must be overridden by subclasses.
	 * Static methods and constructors cannot be abstract.
	 * Abstract methods can specify a method body 
	 * */
	abstract float area();
	
	public int sides() {
		return sideLengths.length;
	}
}