import java.util.Stack;

public class StackExpressionPostfix {

	Stack<Character> stack = new Stack<Character>();

	public void evaluateExpression(String expression) {
		char[] arr = expression.toCharArray();
		String operand = null;
		// loop through the array
		for (int i = 0; i < arr.length; i++) {
			// check for the operands in the array
			if ((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z')) {
				if (operand == null) {
					operand = Character.toString(arr[i]);
				} else {
					operand = operand + arr[i];
				}
			}
			else if (isOpenparanthasis(arr[i])) {
				stack.push(arr[i]);
			} else if (isClosingparanthasis(arr[i])) {
				while (!stack.isEmpty() && !isOpenparanthasis(stack.peek())) {
					operand = operand + Character.toString(stack.pop());
				}
				stack.pop();
			} else {
				if(stack.isEmpty() || isOpenparanthasis(stack.peek())) {
					stack.push(arr[i]);
				}else {
				while (!stack.isEmpty() && hasPrecedence(arr[i]) < hasPrecedence(stack.peek())) {
					operand = operand + Character.toString(stack.pop());
				}
				stack.push(arr[i]);
				}
				
			}
		}
		while (!stack.empty())
		{
			operand = operand + Character.toString(stack.pop());
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackExpressionPostfix stackExpression = new StackExpressionPostfix();
		stackExpression.evaluateExpression("((A+B)*C-D)*E");
		stackExpression.evaluateExpression("((A+B)*C)-(D*E)");
		stackExpression.evaluateExpression("{[A*B]+[C*D]}-E");
		stackExpression.evaluateExpression("(A-B/C)*(A/K-L)");

	}

}
