class Node1 {
	char data;
	Node1 next;
}

public class LinkedListLoop {
	Node1 head;

	public void insertNode(char c) {

		Node1 newNode = new Node1();
		newNode.data = c;
		newNode.next = null;
		Node1 current = head;

		if (head == null) {
			head = newNode;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void createLoop(char c) {

		Node1 newNode = new Node1();
		newNode.data = c;
		newNode.next = head.next;
		Node1 current = head;

		if (head == null) {
			head = newNode;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public boolean isListHavingLoop() {
		if (head == null || head.next == null) {
			return false;
		} else {
			Node1 slow = head;
			Node1 fast = head.next;
			while (slow != fast) {
				if (fast == null || fast.next == null) {
					return false;
				} else {
					slow = slow.next;
					fast = fast.next.next;
				}
			}
			return true;
		}
	}
	
	public void removeDuplicates() {
		Node1 previous=head;
		Node1 current=previous.next;
		while(current != null) {
			if(previous.data == current.data) {
				previous.next = current.next;
				current = current.next;
			}else {
				previous = current;
				current = current.next;
			}
		}
		
	}

	public void removeDuplicatesFromUnsortedList() {
		Node1 outerLoopCurrent = head;
		int outerLoopCount = 1;
		int innerLoopCount = 1;
		Node1 innerLoopCurrent = head;
		Node1 innerLoopprevious = null;
		while(outerLoopCurrent != null) {
			char valueToCompare = outerLoopCurrent.data;
			//re-initialize inner Loop current and count
			innerLoopCurrent = head;
			innerLoopCount = 1;
			while(innerLoopCurrent != null) {
				if(innerLoopCount != outerLoopCount) {
					//if duplicates are find then remove the duplicate node
					if(innerLoopCurrent.data == valueToCompare) {
						innerLoopprevious.next = innerLoopCurrent.next;
						innerLoopCurrent = innerLoopCurrent.next;
					}else {
						innerLoopprevious = innerLoopCurrent;
						innerLoopCurrent = innerLoopCurrent.next;
					}
				}else {
					innerLoopprevious = innerLoopCurrent;
					innerLoopCurrent = innerLoopCurrent.next;
				}
				innerLoopCount++;
			}
			outerLoopCount++;
			outerLoopCurrent = outerLoopCurrent.next;
		}
	}
	public void printList() {
		Node1 current = head;
		while (current.next != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.print(current.data + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListLoop linkedListLoop = new LinkedListLoop();
//		linkedListLoop.insertNode('A');
//		linkedListLoop.insertNode('B');
//		linkedListLoop.insertNode('F');
//		linkedListLoop.insertNode('A');
//		linkedListLoop.insertNode('D');
//		linkedListLoop.insertNode('E');
//		linkedListLoop.insertNode('F');
//		linkedListLoop.insertNode('K');
//		linkedListLoop.insertNode('B');
//		linkedListLoop.insertNode('E');
		
		linkedListLoop.insertNode('A');
		linkedListLoop.insertNode('B');
		linkedListLoop.insertNode('C');
		linkedListLoop.insertNode('D');
		linkedListLoop.insertNode('E');
		linkedListLoop.insertNode('E');
		
		
		//linkedListLoop.createLoop('E');
		System.out.println("Is List having Loop:"+linkedListLoop.isListHavingLoop());
		linkedListLoop.printList();
		
		linkedListLoop.removeDuplicates();
		System.out.println("After removing duplicates:");
		linkedListLoop.printList();
		
//		linkedListLoop.removeDuplicatesFromUnsortedList();
//		System.out.println("After removing duplicates:");
//		linkedListLoop.printList();
		
	}

}
