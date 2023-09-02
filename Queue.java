package in.DS_Implementations;

public class Queue {

	class BadQueueOperationException extends Exception {

		private static final long serialVersionUID = -1886350312664230792L;

		private BadQueueOperationException(String msg) {
			super(msg);
		}
	}

	int size;
	int rear = -1;
	int front = 0;
	private int[] queue;

	public Queue(int size) {
		this.size = size;
		queue = new int[size];
	}

	/**
	 * @param data that fills the queue
	 * @throws BadQueueOperationException if Queue is Full in Size.
	 */
	public void add(int data) throws BadQueueOperationException {
		if (rear == size - 1)
			throw new BadQueueOperationException("Unable to add element -> Queue is Full!");
		queue[++rear] = data;
	}

	/**
	 * @return This Method returns first element from queue and also removes it.
	 * @throws BadQueueOperationException if Queue is Empty
	 */
	public int poll() throws BadQueueOperationException {
		if (isEmpty())
			throw new BadQueueOperationException("Unable to Poll -> Queue is Empty!");

		int polled = queue[front];
		queue[front++] = 0;

		return polled;
	}

	/**
	 * @return This Method returns first element from queue
	 * @throws BadQueueOperationException if Queue is Empty
	 */
	public int peek() throws BadQueueOperationException {
		if (isEmpty())
			throw new BadQueueOperationException("Unable to peek -> Queue is Empty!");
		return queue[front];

	}

	/**
	 * @return checks it the queue is empty or not
	 */
	public boolean isEmpty() {
		return rear == -1 || front > rear;
	}

	/**
	 * Prints the entire queue.
	 */
	public void print() {
		for (int i = front; i <= rear; i++) {
			System.out.print(queue[i] + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) throws BadQueueOperationException {

		Queue queue = new Queue(5);

		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);

		queue.print();

		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		queue.print();

	}

}
