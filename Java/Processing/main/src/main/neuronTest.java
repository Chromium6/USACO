package main;
import java.util.*;

public class neuronTest {
	
	/* settings */
	int n = 2; // number of inputs
	
	public static void main(String[] args) {
		Neuron k = new Neuron(2, true);
		k.setLearningRate(0.01f);
		int[] inputs = new int[2];
		// train
		Random m = new Random();
		float min = 100, max = 0;
		for (int i = 0; i < 100; i ++) {
			inputs[0] = m.nextInt();
			inputs[1] = m.nextInt();
			float l = k.feedFoward(inputs);
			min = Math.min(min, l);
			max = Math.max(max, l);
		}
		System.out.println("[" + min + ", " + max + "]");
		/*
		for (int i = 0; i < 1000; i ++) {
			int[] l = new int[2];
			l[0] = m.nextInt();
			l[1] = m.nextInt();
			k.train(l, f(l[0]));
		}
		System.out.println(k.feedFoward(inputs));*/
	}
	
	// for supervised training (linear equation)
	private static int f(int x) {
		int y = 2*x + 9;
		return y;
	}

}
