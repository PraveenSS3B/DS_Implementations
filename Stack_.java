package in.DS_Implementations;

public class Stack_ {

	int size;

	int[] stack;

	int top = -1;

	public Stack_(int size) {
		this.size = size;
		stack = new int[size];
	}

	public void push(int data) {
		if (top == size - 1)
			return;

		stack[++top] = data;
	}

	public int pop() {
		if (top == -1)
			return 0;

		int pop = stack[top];
		stack[top--] = 0;

		return pop;

	}

	public void print() {
		for (int i = top; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}

	public static void main(String[] args) {
		Stack_ s = new Stack_(5);

		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);

		s.print();
		System.out.println("---------------");

		System.out.println("element popped : " + s.pop());

		System.out.println("---------------");

		s.print();

	}

}
