package turing.googleauth;
import java.io.File;

public class QualityControl {

	public static void main(String[] args) {  
		String currentDirectory;
		File file = new File(".");
		currentDirectory = file.getAbsolutePath();
		System.out.println("Current working directory : "+currentDirectory);
	}

}
