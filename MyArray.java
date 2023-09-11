package in.DS_Implementations;

public class MyArray {

	private int[] arr;

	int n;

	/**
	 * Constructor that initializes the size of the array
	 * @param n -> the size of the array.
	 */
	public MyArray(int n) {
		this.n = n;
		arr = new int[n];
	}

	/**
	 * 
	 * @param index inserts element at the specified index
	 * @param data  that goes into index.
	 */
	public void insert(int index, int data) {
		if (index <= n - 1) {
			arr[index] = data;
		}
	}

	/**
	 * 
	 * @param data that adds the element at end of array
	 */
	public void addRear(int data) {
		arr[n - 1] = data;
	}

	/**
	 * 
	 * @param this method removes the element at this specified index
	 */
	public void remove(int index) {
		if (index <= n - 1) {
			arr[index] = 0;
		}
	}

	/**
	 * 
	 * @param specify index to get the data
	 * @return gets the data at the specified index
	 */
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
