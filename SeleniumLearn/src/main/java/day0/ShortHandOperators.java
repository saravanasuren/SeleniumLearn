package day0;

public class ShortHandOperators {

	public static void main(String[] args) {
		//ShortHand Operators +=, -=, *=, /=, etc.. 
		// i = i + 2; and i +=2; are both same. Later is Shorthand method
		byte b = 8;
		b = (byte)(b*2.5); // Type Casting ==> Narrowing Concept - Refer to notes
		System.out.println(b);
		b *= 2.5;
		System.out.println(b);
	}

}
