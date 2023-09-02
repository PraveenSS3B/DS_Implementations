package in.DS_Implementations;

public class MyArray {

	private int[] arr;

	int n;

	public MyArray(int n) {
		this.n = n;
		arr = new int[n];
	}

	public void insert(int index, int data) {
		if (index <= n - 1) {
			arr[index] = data;
		}
	}

	public void addRear(int data) {
		arr[n - 1] = data;
	}

	public void remove(int index) {
		if (index <= n - 1) {
			arr[index] = 0;
		}
	}

	public int get(int index) {
		if (index <= n - 1)
			return arr[index];

		return 0;
	}

	public void print() {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	public static void main(String[] args) {

		MyArray arr = new MyArray(3);

		arr.insert(0, 10);
		arr.insert(1, 20);
		arr.insert(2, 30);

		arr.print();
	}

}
