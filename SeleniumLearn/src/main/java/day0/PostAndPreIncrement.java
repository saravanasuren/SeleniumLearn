package day0;

public class PostAndPreIncrement {

	public static void main(String[] args) {
		int i = 5;
		i += 1;
		System.out.println("i: " + i);
		int j = i;
		System.out.println("j: "+ j);
		i++; //Same as i+=1
		System.out.println("i: " + i);
		i = 5; //Resetting i value 
		j = i++;
		System.out.println("j while using i++ - This is post increment: " + j);
		i = 5; //Resetting i value
		j = ++i;
		System.out.println("j while using ++i - This is pre increment: " + j);
	}

}
