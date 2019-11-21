import java.util.Stack;

public class StackExpressionPrefix1 {
	Stack<Integer> operand = new Stack<Integer>();
	Stack<Character> operator = new Stack<Character>();
	String results = null;
	Integer temp = null;

	public void evaluateExpression(String expression) {
		char[] arr = expression.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			// check for the operands in the array
			if (arr[i] >= '0' && arr[i] <= '9') {
				operand.push(Integer.valueOf(Character.toString(arr[i])));
			}
			// Check for open parenthesis
			else if (isOpenparenthesis(arr[i])) {
				operator.push(arr[i]);
			}
			// Check for close parenthesis
			else if (isClosingparenthesis(arr[i])) {
				while (!operator.isEmpty() && !isOpenparenthesis(operator.peek())) {
					Integer op2 = operand.pop();
					Integer op1 = operand.pop();
					//operand.push(Character.toString(operator.pop()) + op1 + op2);
					operand.push(performOperation(op1, op2, operator.pop()));
				}
				operator.pop();
			} else if (operator.isEmpty() || isOpenparenthesis(operator.peek())) {
				operator.push(arr[i]);
			} else {
				while (!operator.isEmpty() && hasPrecedence(arr[i]) < hasPrecedence(operator.peek())) {
					Integer op2 = operand.pop();
					Integer op1 = operand.pop();
					//operand.push(Character.toString(operator.pop()) + op1 + op2);
					operand.push(performOperation(op1, op2, operator.pop()));
				}
				operator.push(arr[i]);
			}
		}
		while (!operator.isEmpty()) {

			if (!operand.isEmpty()) {
				Integer op2 = operand.pop();
				Integer op1 = operand.pop();
				//operand.push(Character.toString(operator.pop()) + op1 + op2);
				operand.push(performOperation(op1, op2, operator.pop()));
			} else {
				temp = Integer.valueOf(Character.toString(operator.pop()));
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

	public int performOperation(int op1, int op2, char c) {
		switch (c) {
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		case '*':
			return op1 * op2;
		case '/':
			return op1 / op2;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackExpressionPrefix1 stackExpressionPrefix = new StackExpressionPrefix1();
		stackExpressionPrefix.evaluateExpression("(2*3)+(6/2)");
		stackExpressionPrefix.evaluateExpression("(4-2/2)*(4/2-1)");
		stackExpressionPrefix.evaluateExpression("((2+3)*4-5)*2");
		stackExpressionPrefix.evaluateExpression("((2+3)*5)-(2*3)");
		stackExpressionPrefix.evaluateExpression("{[2*3]+[3*4]}-2");
	}
}
