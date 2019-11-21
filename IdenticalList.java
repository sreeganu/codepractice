/**
 * 
 */

/**
 * @author 12069
 *
 */
public class IdenticalList {

     static Node head1;
	 static Node head2;
	public Node insertToList(Node head,int data) {
		Node current = head;
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		
		if (head == null) {
			head = newNode;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		return head;
	}
	public void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	public int sizeOfList(Node head) {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	public boolean isIdentical(Node head1,Node head2) {
		
		if(head1 == null || head2 == null) {
			System.out.println("List is empty");
			return false;
		}else {
			if(sizeOfList(head1)!=sizeOfList(head2)) {
				System.out.println("List sizes are not equal, so thay are not identical");
				return false;
			}else {
				while(head1 != null && head2!= null) {
					if(head1.data==head2.data) {
						head1 = head1.next;
						head2 = head2.next;
					}else {
						System.out.println("elements are not equal, so thay are not identical");
						return false;
					}
				}
				System.out.println("Lists are identical");
				return true;
			}
		}
	}
	public static void main(String[] args) {

		IdenticalList identicalList = new IdenticalList();
		
		head1 = identicalList.insertToList(head1,12);
		head1 = identicalList.insertToList(head1,99);
		head1 = identicalList.insertToList(head1,8);
		head1 = identicalList.insertToList(head1,39);
		head1 = identicalList.insertToList(head1,5);
		
		System.out.println("Size of List1--->"+identicalList.sizeOfList(head1));
		System.out.println("printList1---->");
		identicalList.printList(head1);
		
		head2 = identicalList.insertToList(head2,12);
		head2 = identicalList.insertToList(head2,99);
		head2 = identicalList.insertToList(head2,8);
		head2 = identicalList.insertToList(head2,39);
		head2 = identicalList.insertToList(head2,5);
		
		System.out.println("Size of List2--->"+identicalList.sizeOfList(head2));
		System.out.println("printList2---->");
		identicalList.printList(head2);
		
		identicalList.isIdentical(head1, head2);
		
	}
}
