package in.DS_Implementations;

public class DoublyLinkedList {

	class Node {
		Node prev;
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

	}

	Node head;
	Node tail;

	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}

		Node currNode = head;
		while (currNode.next != null) {
			currNode = currNode.next;
		}

		currNode.next = newNode;
		newNode.prev = currNode;
		tail = newNode;
	}

	public void prepend(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}

		Node currNode = tail;
		while (currNode.prev != null) {
			currNode = currNode.prev;
		}

		currNode.prev = newNode;
		newNode.next = currNode;
		head = newNode;

	}

	public void printForward() {
		Node currNode = head;

		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}

		System.out.println();

	}

	public void printBackward() {
		Node currNode = tail;

		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.prev;
		}

		System.out.println();

	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		list.printForward();

		list.printBackward();

		list.prepend(-10);
		list.prepend(-20);
		list.prepend(-30);
		list.prepend(-40);

		list.printForward();

		list.printBackward();
	}

}
