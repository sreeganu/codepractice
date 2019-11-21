class Node{
	int data;
	Node next;
}

public class SingleLinkedList {
	Node head;
	static int listSize =0;
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		head= newNode;
	}
	public void insertLast(int data) {
		Node current = head;
		while(current.next!=null) {
			current = current.next;
		}
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = null;
			current.next =newNode;
	}
	
	public void insertChar(char c) {
		Node current;
		Node newNode = new Node();
		newNode.data = c;
		newNode.next = null;	
		if(head == null) {
			head= newNode;
		}else {
			current = head;
			while(current.next!=null) {
				current = current.next;
			}
			current= newNode;
		}
	}
	public void insertAfter(int after, int data) {
		Node current  = head;
		Node temp; 
		while(current.next!= null) {
			if(current.data == after) {
				temp = current.next;
				Node newNode = new Node();
				newNode.data = data;
				newNode.next = temp;
				current.next =newNode;
			}
				current = current.next;
			
		}
	}
	
	public int deleteFirst() {
		Node temp = head;
		head = temp.next;
		return temp.data;
	}
	
	public int listSize() {
		Node current = head;
		listSize = 0 ;
		while(current != null) {
			listSize++;
			current= current.next;			
		}
		
		return listSize;
	}
	
	public int getElementAt(int location) {
		Node current = head;
		int count=0;
		int elementAtLocation = 0;
		while(current != null) {
			count++;
			if(count == location) {
				
				elementAtLocation= current.data;
				break;
				
			}else {
				current = current.next;
			}
		}
		return elementAtLocation;
	}
	
	public int getElementAtPositionFromLast(int position) {
		Node current = head;
		int count=0;
		position = (listSize() - position) +1; 
		int elementAtLocation = 0;
		while(current != null) {
			count++;
			if(count == position) {
				
				elementAtLocation= current.data;
				break;
				
			}else {
				current = current.next;
			}
		}
		return elementAtLocation;
	}
	
	public void printLinkedList() {
		System.out.println("Printing LinkedList (head --> last) ");
		Node current = head;
		while (current != null) {
			System.out.print(current.data);
			current = current.next;
		}
		System.out.println();
	}
	
	public void reverseList() {
		Node current = head;
		Node next;
		Node previous = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
    	}
		head = previous;
	}
	public void checkforPalindrome() {
		Node current = head;
		int count = 1;
		int midvalue = listSize()/2;
		while(current!= null) {
			if(count != midvalue) {
				if(getElementAt(count)==getElementAtPositionFromLast(count)) {
					count++;
					current = current.next;
				}
				else {
					System.out.println("Not Palindrome");
					break;
				}
			}else {
				if(getElementAt(count)==getElementAtPositionFromLast(count)) {
					System.out.println("Palindrome");
					break;
				}else {
					System.out.println("Not Palindrome");
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedList linkedList = new SingleLinkedList();
//		linkedList.insertFirst(10);
//		linkedList.insertLast(20);
//		linkedList.insertLast(30);
//		linkedList.insertLast(40);
//		linkedList.insertLast(50);
//		linkedList.insertLast(60);
//		linkedList.insertLast(70);
//		linkedList.insertLast(80);
//		linkedList.insertLast(90);
//		linkedList.insertLast(100);
//		linkedList.printLinkedList();
//		linkedList.printLinkedList();
		
		linkedList.insertFirst('M');
		linkedList.insertLast('A');
		linkedList.insertLast('S');
		linkedList.insertLast('K');
		linkedList.insertLast('D');
		linkedList.insertLast('K');
		linkedList.insertLast('S');
		linkedList.insertLast('A');
		linkedList.insertLast('M');
		System.out.println("List Size:"+linkedList.listSize());
		linkedList.printLinkedList();
		linkedList.checkforPalindrome();
		
		
		//linkedList.insertAfter(10, 15);
		
			
//		System.out.println("List Size:"+linkedList.listSize());
//		System.out.println("Element at Location 2 --->"+linkedList.getElementAt(2));
//		System.out.println("Element at Location 2 from last--->"+linkedList.getElementAtPositionFromLast(2));
		
//		linkedList.reverseList();
//		linkedList.printLinkedList();
		
//		System.out.println("In delete:"+linkedList.deleteFirst());
//		linkedList.printLinkedList();	

	}

}
