package day0;

public class DistanceConversion {

	public static void main(String[] args) {
	int m;
	@SuppressWarnings("unused")
	double km;
	for (m=100 ; m < 1001 ; m+=100) {
		System.out.println(m + " meters is equal to " + (km = (double)m/1000) + " kilometers");
		/*in the above stmt double is used - else for 100 to 900 meters - result will be 0.0 km 
		instead of correct value as m is mentioned as integer*/
	}

	}

}
