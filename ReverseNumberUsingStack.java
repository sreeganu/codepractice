import java.util.Stack;

public class ReverseNumberUsingStack {
	Stack<Integer> stack = new Stack<Integer>();
	int reverse = 0;
	int i = 1;

	public void pushElements(int num) {
		if (num != 0) {
			while (num >= 1) {
				stack.push(num % 10);
				num = num / 10;
			}
		} else {
			System.out.println("invalid number");
		}
	}

	public void reverseNumber() {
		while (!isEmpty()) {
			reverse = reverse + stack.pop() * i;
			i = i * 10;
		}
		System.out.println("Reverse------>" + reverse);
	}

	public int popElements() {
		return stack.pop();
	}

	public boolean isEmpty() {
		return stack.empty();
	}

	public void peek() {
		System.out.println(stack.peek());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReverseNumberUsingStack reverseNumberUsingStack = new ReverseNumberUsingStack();
		int number = 12345;
		System.out.println("Number ----->" + number);
		reverseNumberUsingStack.pushElements(number);
		/*
		 * reverseNumberUsingStack.peek(); reverseNumberUsingStack.popElements();
		 * reverseNumberUsingStack.peek(); reverseNumberUsingStack.popElements();
		 * reverseNumberUsingStack.peek(); reverseNumberUsingStack.popElements();
		 * reverseNumberUsingStack.peek(); reverseNumberUsingStack.popElements();
		 * reverseNumberUsingStack.peek(); reverseNumberUsingStack.popElements();
		 */

		reverseNumberUsingStack.reverseNumber();
		System.out.println("Is Empty------------>" + reverseNumberUsingStack.isEmpty());
	}

}
