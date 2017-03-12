package weeklyHomeWork;

public class FibonocciSeriesFrom1To100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1, n2, n3, count = 11;
		
		n1 = 0; n2 = 1;
		System.out.print(n1 + " " + n2);
		
		for (int i = 2; i<=count; i++){
			
			n3 = n1 + n2;
			System.out.print(" " + n3);
			n1=n2;    
			n2=n3; 
		}

	}

}
