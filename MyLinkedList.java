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

		ll.display();

		ll.insert(40, 3);

		ll.display();

		ll.insert(25, 2);

		ll.display();

		ll.delete(2);

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

	public void insert(int data, int index) {
		Node newNode = new Node(data);

		Node curr = head;

		int currIndex = 0;

		if (index == 0) {
			prepend(data);
			return;
		}

		while (index != currIndex && curr != null) {

			if (currIndex++ == index - 1) {
				Node temp = curr.next;
				curr.next = newNode;
				newNode.next = temp;
				return;
			}

			curr = curr.next;
		}
	}

	public void delete(int index) {
		Node current = head;

		int currentIndex = 0;

		if (current == null)
			return;

		while (currentIndex != index) {
			if (currentIndex++ == index - 1) {
				current.next = current.next.next;
				return;
			}

			current = current.next;
		}
	}

	public void pop() {
		Node current = head;

		if (current == null)
			return;

		while (current.next.next != null) {
			current = current.next;
		}

		current.next = null;
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

	public void shift() {
		Node current = head.next;

		head = current;
	}

	public void display() {
		Node current = head;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}

		System.out.println();
	}

}
