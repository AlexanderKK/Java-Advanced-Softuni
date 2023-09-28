package _01StacksAndQueues._02Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06RecursiveFibonacci {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		if(n >= 1 && n <= 49) {
			if(n == 1) {
				System.out.println(1);
			} else {
				long result = getFibonacci(n - 1) + getFibonacci(n - 2);
				System.out.println(result);
			}
		}
	}

	private static long getFibonacci(int n) {
		ArrayDeque<Long> seq = new ArrayDeque<>();

		//1 1 2 3 5
		seq.push(1L);
		long lastElement = 1;
		long curElement;

		//I miss one iteration because I add 1 to stack in the beginning
		n -= 2;

		int i = 0;
		while(i <= n) {
			if(i == 0) {
				//get 2 from 1 + 1
				seq.push(seq.pop() + lastElement);
			} else {
				//get current element in stack
				curElement = seq.pop();   //5
				//push sum of current and last one
				seq.push(curElement + lastElement);   //5 + 3
				//get last element which will be equal to current
				lastElement = curElement;   //5
			}
			i++;
		}
		return seq.pop();
	}
}
