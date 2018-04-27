package engine;

<<<<<<< HEAD
import java.io.InputStream;
=======
>>>>>>> 83b3708e0161c4040a20136b2de2c7fbae444426
import java.util.Scanner;

public class HelperScanner {

	private static Scanner scanner;// = new Scanner(System.in);
	
//	public static Scanner getScanner() {
//		return scanner;
//	}
	
	public static void create() {
		scanner = new Scanner(System.in);
	}
	
<<<<<<< HEAD
	public static void create(InputStream stream) {
		scanner = new Scanner(stream);
	}
=======
//	public static void create(InputStream stream) {
//		scanner = new Scanner(stream);
//	}
>>>>>>> 83b3708e0161c4040a20136b2de2c7fbae444426
	
	public static int nextInt() {
		if (scanner == null)
			create();
		
//		int value = scanner.nextInt();
		return scanner.nextInt();
	}
	
	public static String next() {

		if (scanner == null)
			create();
		
		return scanner.next();
	}
	
	public static void reset() {
		if (scanner == null)
			create();
		scanner.reset();
	}
	
	
}
