import java.util.Stack;

public class StackExpressionPrefix {
	Stack<String> operand = new Stack<String>();
	Stack<Character> operator = new Stack<Character>();
	String results = null;
	String temp = null;

	public void evaluateExpression(String expression) {
		char[] arr = expression.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			// check for the operands in the array
			if ((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z')) {
				operand.push(Character.toString(arr[i]));
			}
			// Check for open parenthesis
			else if (isOpenparenthesis(arr[i])) {
				operator.push(arr[i]);
			}
			// Check for close parenthesis
			else if (isClosingparenthesis(arr[i])) {
				while (!operator.isEmpty() && !isOpenparenthesis(operator.peek())) {
					String op2 = operand.pop();
					String op1 = operand.pop();
					operand.push(Character.toString(operator.pop()) + op1 + op2);
				}
				operator.pop();
			} else if (operator.isEmpty() || isOpenparenthesis(operator.peek())) {
				operator.push(arr[i]);
			} else {
				while (!operator.isEmpty() && hasPrecedence(arr[i]) < hasPrecedence(operator.peek())) {
					String op2 = operand.pop();
					String op1 = operand.pop();
					operand.push(Character.toString(operator.pop()) + op1 + op2);
				}
				operator.push(arr[i]);
			}
		}
		while (!operator.isEmpty()) {

			if (!operand.isEmpty()) {
				String op2 = operand.pop();
				String op1 = operand.pop();
				operand.push(Character.toString(operator.pop()) + op1 + op2);
			} else {
				temp = Character.toString(operator.pop());
				operand.push(temp);
			}
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

	public boolean isOpenparenthesis(char c) {
		switch (c) {
		case '(':
		case '{':
		case '[':
			return true;
		}
		return false;

	}

	public boolean isClosingparenthesis(char c) {
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
		StackExpressionPrefix stackExpressionPrefix = new StackExpressionPrefix();
		stackExpressionPrefix.evaluateExpression("(A*B)+(C/D)");
		stackExpressionPrefix.evaluateExpression("(A-B/C)*(A/K-L)");
		stackExpressionPrefix.evaluateExpression("((A+B)*C-D)*E");
		stackExpressionPrefix.evaluateExpression("((A+B)*C)-(D*E)");
		stackExpressionPrefix.evaluateExpression("{[A*B]+[C*D]}-E");
	}

}
