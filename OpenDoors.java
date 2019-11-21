
public class OpenDoors {

	public static int count = 0;

	// method to print the divisors
	static void findDivisors(int n) {
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
				//System.out.printf("%d ", i);
			}
		}

		//System.out.println();
		openDoor(count, n);
		count = 0;
	}

	static void openDoor(int count, int n) {
		if (count % 2 == 1) {
			System.out.println(n + " "+"door is open");
		}
	}

	// Driver method
	public static void main(String args[]) {
		for (int i = 1; i <= 100; i++) {
			//System.out.println("The divisors of " + i + " are: ");
			findDivisors(i);
		}

	}
}
