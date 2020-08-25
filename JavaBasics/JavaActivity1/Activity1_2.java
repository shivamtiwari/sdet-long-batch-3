package JavaActivity1;

import java.util.Arrays;

class Activity1_2 {
	public static void main(String[] args) {
		int[] numArr = { 10, 77, 10, 54, -11, 10 };
		System.out.println("Original Array: " + Arrays.toString(numArr));
		System.out.println("Size of the Array: " + numArr.length);
		int searchNum = 10;
		int fixedSum = 30;
		System.out.println("Result: " + result(numArr, searchNum, fixedSum));
	}

	public static boolean result(int[] numbers, int searchNum, int fixedSum) {
		int temp_sum = 0;
		for (int number : numbers) {
			if (number == 10) {
				temp_sum += 10;
			}
			if (temp_sum > 30) {
				break;
			}
		}
		return temp_sum == fixedSum;
	}
}