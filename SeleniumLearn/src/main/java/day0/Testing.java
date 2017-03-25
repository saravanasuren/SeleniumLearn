package day0;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String Str = "Suren Corp. (12345)";
		
		/*System.out.println(Str.length());
		
		String ActualStr = Str.substring((Str.length()-6), (Str.length()-1));
		System.out.println(ActualStr);
		
		//String str = "Hello (Java)";
*/		String answer = Str.substring(Str.indexOf("(")+1,Str.indexOf(")"));
		System.out.println(answer);
	}

}
