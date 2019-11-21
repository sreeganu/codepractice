
public class HighestEvenFibonacci {
	int fibonacciNumber = 0;

	public int fibonacci(int length) {
		int first = 0;
		int next = 1;
		int highest = 0;
		int arr[] = new int[length];
		arr[0] = first;
		arr[1] = next;
		System.out.println("number in " + 0 + "th position is:" + arr[0]);
		System.out.println("number in " + 1 + "st position is:" + arr[1]);
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[first] + arr[next];
			System.out.println("number in " + i + "rd position is:" + arr[i]);
			fibonacciNumber = arr[i];
			if (arr[i] % 2 == 0) {
				highest = arr[i];
			}
			next = i;
			first = i - 1;
		}

		System.out.println("Nth Even Fibonacci Number" + highest);
		return fibonacciNumber;
	}
	public void lastTwoDigits(int fibonacciNumber) {
		int length = String.valueOf(fibonacciNumber).length();
		System.out.println("Fibonacci Number length" + length);
		char arr[] = String.valueOf(fibonacciNumber).toCharArray();
		for(int i = arr.length-2;i>arr.length;i++) {
			System.out.print(arr[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HighestEvenFibonacci highestEvenFebinocci = new HighestEvenFibonacci();
		int fibonacciNumber = highestEvenFebinocci.fibonacci(15);
		//highestEvenFebinocci.lastTwoDigits(fibonacciNumber);
		
	}

}
