package in.DS_Implementations;

public class MyLinkedList {

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	Node head;

	public static void main(String[] args) {

		MyLinkedList ll = new MyLinkedList();

		ll.add(10);
		ll.add(20);
		ll.add(30);

		ll.prepend(-10);
		ll.prepend(-20);

		ll.display();

	}

	public void add(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}

		Node current = head;

		while (current.next != null) {
			current = current.next;
		}

		current.next = newNode;
	}

	public void prepend(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}

		newNode.next = head;

		head = newNode;

	}

	public void display() {
		Node current = head;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

}
