package in.DS_Implementations;

import in.DS_Implementations.Queue.BadQueueOperationException;

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

	/**
	 * @param data that fills the Node
	 */
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

	/**
	 * 
	 * @param data  - that node needs to get filled
	 * @param index - that fills data at this index
	 */
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

	/**
	 * 
	 * @return returns size of the linked list
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
	 * @param index - the node at this index will be deleted.
	 */
	public void delete(int index) {
		Node current = head;

		int currentIndex = 0;

		if (current == null)
			return;

		if (index == 0) {
			head = current.next;
			return;
		}

		if (index == size() - 1) {
			pop();
			return;
		}

		while (currentIndex != index) {
			if (currentIndex++ == index - 1) {
				current.next = current.next.next;
				return;
			}

			current = current.next;
		}
	}

	/**
	 * Pops the last node of the linked list.
	 */
	public void pop() {
		Node current = head;

		if (current == null)
			return;

		while (current.next.next != null) {
			current = current.next;
		}

		current.next = null;
	}

	/**
	 * @param data - adds new node at front of the linked list using the data
	 *             provided
	 */
	public void prepend(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}

		newNode.next = head;

		head = newNode;

	}

	/**
	 * Removes the first node in the list
	 */
	public void shift() {
		Node current = head.next;

		head = current;
	}

	/**
	 * displays the entire linked list..
	 */
	public void display() {
		Node current = head;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}

		System.out.println();
	}

}
