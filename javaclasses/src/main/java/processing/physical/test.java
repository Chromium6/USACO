package processing.physical;

public class test {

	public static void main(String[] args) {
		java.util.Random k = new java.util.Random();
		for (int i = 0; i < 100; i ++)
			System.out.println(k.nextFloat()*2-0.5);

	}

}
