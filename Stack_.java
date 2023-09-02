package in.DS_Implementations;

public class Stack_ {

	private class BadStackOperationException extends Exception {

		private static final long serialVersionUID = -2107592072549488824L;

		private BadStackOperationException(String msg) {
			super(msg);
		}
	}

	int size;

	int[] stack;

	int top = -1;

	public Stack_(int size) {
		this.size = size;
		stack = new int[size];
	}

	/**
	 * @param data that fills the stack
	 * @throws BadStackOperationException if Stack is Full.
	 */
	public void push(int data) throws BadStackOperationException {
		if (top == size - 1)
			throw new BadStackOperationException("Stack is Already Full!");

		stack[++top] = data;
	}

	/**
	 * @return This Method returns top element from stack and also removes it.
	 * @throws BadStackOperationException if stack is Empty
	 */
	public int pop() throws BadStackOperationException {
		if (top == -1)
			throw new BadStackOperationException("Unable to pop: Stack is Empty!");

		int pop = stack[top];
		stack[top--] = 0;

		return pop;

	}

	/**
	 * @return This Method returns Top element from Stack
	 * @throws BadStackOperationException if Stack is Empty
	 */
	public int peek() throws BadStackOperationException {
		if (top == -1)
			throw new BadStackOperationException("Unable to peek: Stack is Empty!");

		return stack[top];

	}

	/**
	 * Prints the entire Stack From Top to Bottom.
	 */
	public void print() {
		for (int i = top; i >= 0; i--) {
			System.out.println(stack[i]);
		}

		System.out.println("-----------------");
	}

	public static void main(String[] args) throws BadStackOperationException {
		Stack_ s = new Stack_(5);

		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);

		s.print();

		s.print();

		s.pop();
		s.pop();
		s.pop();

		s.print();
	}

}
