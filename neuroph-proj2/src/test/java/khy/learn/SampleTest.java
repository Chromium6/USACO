package khy.learn;

import junit.framework.Assert;
import org.junit.*;

public class SampleTest {
	Sample k;
	
	public void init() throws Exception {
	  System.out.println("Setting up ...");
	  k = new Sample();
	}
	
	public void destroy() throws Exception {
		System.out.println("Tearing down ...");
		k = null;
	}
	 
	public void testFunction() {
		Assert.assertNotNull(k);
	 
		System.out.println(k.sanityCheck());
	 }
}
