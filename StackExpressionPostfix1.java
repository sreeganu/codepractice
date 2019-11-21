import java.util.Stack;

public class StackExpressionPostfix1 {

	Stack<Character> stack = new Stack<Character>();

	public void evaluateExpression(String expression) {
		char[] arr = expression.toCharArray();
		Stack<Integer> operand = new Stack<Integer>();
		int op1 = 0;
		int op2 = 0;
		// loop through the array
		for (int i = 0; i < arr.length; i++) {
			// check for the operands in the array
			if ((arr[i] >= '0' && arr[i] <= '9')) {

				operand.push(Integer.parseInt(Character.toString(arr[i])));

			} else if (isOpenparanthasis(arr[i])) {
				stack.push(arr[i]);
			} else if (isClosingparanthasis(arr[i])) {
				while (!stack.isEmpty() && !isOpenparanthasis(stack.peek())) {
					// operand.push(stack.pop());
					op2 = operand.pop();
					op1 = operand.pop();
					operand.push(performOperation(op1, op2,stack.pop()));

				}
				stack.pop();
			} else {
				if (stack.isEmpty() || isOpenparanthasis(stack.peek())) {
					stack.push(arr[i]);
				} else {
					while (!stack.isEmpty() && hasPrecedence(arr[i]) < hasPrecedence(stack.peek())) {
						op2 = operand.pop();
						op1 = operand.pop();
						operand.push(performOperation(op1, op2,stack.pop()));
					}
					stack.push(arr[i]);
				}

			}
		}
		while (!stack.empty()) {
			op2 = operand.pop();
			op1 = operand.pop();
			operand.push(performOperation(op1, op2,stack.pop()));
		}
		System.out.println(operand);
	}

	public int hasPrecedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;

	}

	public boolean isOpenparanthasis(char c) {
		switch (c) {
		case '(':
		case '{':
		case '[':
			return true;
		}
		return false;

	}

	public boolean isClosingparanthasis(char c) {
			switch (c) {
			case ')':
			case '}':
			case ']':
				return true;
			}
			return false;
	}	
		public int performOperation(int op1,int op2,char c) {
			switch(c) {
			case '+':
				return op1 +op2;
			case '-':
				return op1 -op2;
			case '*':
				return op1 * op2;
			}
			return 0;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackExpressionPostfix1 stackExpression = new StackExpressionPostfix1();
		//stackExpression.evaluateExpression("((A+B)*C-D)*E");
		stackExpression.evaluateExpression("((2+3)*5)-(4*6)");
		stackExpression.evaluateExpression("((2+3)*4-5)*6");
		stackExpression.evaluateExpression("{[2*3]+[5*4]}-9");

	}

}
