
// javac HelloWorld.java
// HelloWorld.class
public class HelloWorld {
	public static void main(String[] args) {
		if(args.length <=0) {
			System.out.println("java Hello world");
			System.exit(-1);
		}
		
		String name = args[0];
		System.out.println("Hello" + name);
	}
}
