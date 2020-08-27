package JavaActivity3;

import java.util.LinkedList;
import java.util.Queue;

public class Activity3_3a {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < 10; i=i+2) {
			q.add(i);
		}
		System.out.println("Queue Elements : " + q);
		int size = q.size();
		System.out.println("Original Size : " + size);
		int removeEle = q.remove();
		System.out.println("remove element: " + removeEle);
		int headEle = q.peek();
		System.out.println("queue head: " + headEle);
		 size = q.size();
		System.out.println("Size : " + size);
	}
}