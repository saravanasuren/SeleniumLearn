package dailyQuestions;

public class FactorialofNum {

	public static void main(String[] args) {
		int num = 5;
		for (int i=1;i<=num;i++){
			num = num*(num-1);
		}
		System.out.println(num);
	}

}
