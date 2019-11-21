import java.util.Stack;

/**
 * 
 */

/**
 * @author 12069
 *
 */
public class StackDemo {

	/**
	 * @param args
	 */
	Stack<Integer> stack = new Stack<Integer>();
	public void pushElements(int number) {
		stack.push(number);
		
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
		
		StackDemo stack = new StackDemo();
		stack.pushElements(1);
		stack.pushElements(2);
		stack.pushElements(3);
		stack.pushElements(4);
		stack.pushElements(5);
		
		stack.peek();
		System.out.println("Pop----"+stack.popElements());
		System.out.println("is Empty-------"+stack.isEmpty());
		stack.peek();
		

	}

}
