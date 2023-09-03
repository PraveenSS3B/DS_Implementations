package in.DS_Implementations;

public class CircularQueue {

	private class BadCircularQueueOperationException extends Exception {

		private static final long serialVersionUID = -509708776084324906L;

		private BadCircularQueueOperationException(String msg) {
			super(msg);
		}
	}

	int rear = -1;

	int front = 0;

	int count = 0;

	private int[] queue;

	int size;

	public CircularQueue(int size) {
		this.size = size;
		queue = new int[size];
	}

	public void add(int data) throws BadCircularQueueOperationException {
		if (size == count++)
			throw new BadCircularQueueOperationException("Circular Queue is Full!");

		rear = (rear + 1) % size;
		queue[rear] = data;

	}

	public int poll() throws BadCircularQueueOperationException {

		if (isEmpty())
			throw new BadCircularQueueOperationException("Unable to poll: Queue is Empty!");

		front = (front + 1) % size;
		count--;
		return queue[front];
	}

	public int peek() throws BadCircularQueueOperationException {

		if (isEmpty())
			throw new BadCircularQueueOperationException("Unable to Peek: Queue is Empty!");

		return queue[front];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void print() throws BadCircularQueueOperationException {
		if (isEmpty())
			throw new BadCircularQueueOperationException("Queue is Empty!");
		for (int i = front; i <= rear; i++) {
			System.out.print(queue[i] + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) throws BadCircularQueueOperationException {
		CircularQueue cq = new CircularQueue(5);

		cq.add(10);
		cq.add(20);
		cq.add(30);
		cq.add(40);
		cq.add(50);

		for (int i = 0; i < cq.size; i++) {
			System.out.println("Polled: " + cq.poll());
		}

		cq.add(10);
		cq.add(20);
		cq.add(30);
		cq.add(40);
		cq.add(50);

		cq.print();
		
		System.out.println("Peek: " + cq.peek());

	}

}
