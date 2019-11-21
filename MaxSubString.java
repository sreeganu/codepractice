
public class MaxSubString {
	int maxSize = 10;
	char[] stackArray = new char[maxSize];;
	int top = -1;
	char[] finalSubString = new char[10];
	int count = 0;

	public void push(char j) {
		stackArray[++top] = j;
	}

	public char pop() {
		return stackArray[top--];
	}

	public char peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public void charArrayCompare(char arr1[], char arr2[]) {

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					//if stack is empty push the elements
					if (isEmpty()) {
						push(arr1[i]);
					} else {
						//if stack is not empty 
						//check whether matching letters index are in sequence 
						if (count == j - 1) {
							push(arr1[i]);
						} else {
							//if letters indexes are not in sequence and stack has some elements copy the element into temp array
							if (top >= 0) {
								finalSubString = stackArray.clone();
							}
							//remove the copied elements from stack
							for (int k = top; k >-1 ; k--) {
								pop();
							}
							//insert new matching element into the sequence
							push(arr1[i]);
						}
					}
					count = j;
				}

			}
		}

		int stackArrayactualSize = arrylength(stackArray);
		int finalSubStringActualSize = arrylength(finalSubString);

		if (stackArrayactualSize > finalSubStringActualSize) {
			System.out.println("stackArrayactualSize----" + stackArrayactualSize);
		} else {
			System.out.println("finalSubStringActualSize -----------" + finalSubStringActualSize);
		}

	}
	

	public int arrylength(char[] arr) {
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "MNQSRILAT";
		String str2 = "MNWSRILAT";
		MaxSubString maxSubString = new MaxSubString();
		maxSubString.charArrayCompare(str1.toCharArray(), str2.toCharArray());
	}
	
	// need add function to handle size while we are copy the array to finalSubString

}
