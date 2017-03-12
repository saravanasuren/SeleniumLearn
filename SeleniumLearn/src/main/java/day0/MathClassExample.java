package day0;

public class MathClassExample {

	public static void main(String[] args) {
		double x, y, z; 
		x = 3; y = 4; 
		z = Math.sqrt(x*x + y*y); 
		System.out.println("Hypotenuse is " +z);
		z = Math.PI;
		System.out.println(z);
		z = Math.E;
		System.out.println(z);
		z= Math.pow(x, y);
		System.out.println("Power of x & y is: " + z);
	}

}
