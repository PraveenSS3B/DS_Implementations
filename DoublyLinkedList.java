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

	/**
	 * @return returns size of the Doubly linked list
	 */
	public int size() {
		Node currNode = head;

		int size = 0;

		while (currNode != null) {
			size++;
			currNode = currNode.next;
		}

		return size;
	}

	/**
	 * @param adds the Node at the end of the List with the provided data
	 */
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

	/**
	 * @param data - adds new node at front of the Doubly linked list using the data
	 *             provided
	 */
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

	/**
	 * @param data  - that node needs to get filled
	 * @param index - that fills data at this index
	 */
	public void insert(int index, int data) {
		if (head == null || tail == null) {
			System.out.println("Doubly Linked List is Empty!");
			return;
		}

		if (index == 0) {
			prepend(data);
			return;
		}

		if (index == size() - 1) {
			add(data);
			return;
		}

		int currIndex = 0;

		Node newNode = new Node(data);
		Node currNode = head;

		while (currIndex != index) {
			if (currIndex++ == index - 1) {

				Node pushNode = currNode.next;

				currNode.next = newNode;
				newNode.prev = currNode;

				pushNode.prev = newNode;
				newNode.next = pushNode;
				return;

			}
			currNode = currNode.next;
		}
	}

	/**
	 * @param index - the node at this index will be deleted.
	 */
	public void remove(int index) {
		if (head == null || tail == null) {
			System.out.println("Doubly Linked List is Empty!");
			return;
		}

		if (index == 0) {
			shift();
			return;
		}

		if (index == size() - 1) {
			pop();
			return;
		}

		int currIndex = 0;

		Node currNode = head;

		while (currIndex != index) {
			if (currIndex++ == index - 1) {

				Node deleteNode = currNode.next;
				Node nextNode = deleteNode.next;

				currNode.next = nextNode;
				nextNode.prev = currNode;

			}
			currNode = currNode.next;
		}
	}

	/**
	 * Removes the first node in the Doubly Linked List
	 */
	public int shift() {
		int shifted = head.data;

		head = head.next;

		head.prev = null;

		return shifted;
	}

	/**
	 * Pops the last node of the Doubly linked list.
	 */
	public int pop() {

		int popped = tail.data;

		tail = tail.prev;

		tail.next = null;

		return popped;
	}

	/**
	 * displays the entire linked list from left to right
	 */
	public void printForward() {
		Node currNode = head;

		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}

		System.out.println();

	}

	/**
	 * displays the entire linked list from right to left
	 */
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

		list.insert(1, -10);

		list.printForward();

		list.printBackward();

	}

}
