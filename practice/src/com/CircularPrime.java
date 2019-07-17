package com;

public class CircularPrime {
	public static void main(String[] args) {
		int n = 1193;
		if (circularPrime(n)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private static boolean circularPrime(int n) {
		int count = 0, temp = n;
		while (temp > 0) {
			temp = temp / 10;
			count++;
		}
		int num = n;
		while (isPrime(num)) {
			System.out.println(num);
			int rem = num % 10;
			int div = num / 10;
			num = (int) ((Math.pow(10, count - 1)) * rem) + div;
			if(num == n) 
				return true;
		}
		return false;
	}

	private static boolean isPrime(int num) {
		boolean result = true;
		for (int i = 2; i <= num - 1; i++) {
			if (num % i == 0) {
				result = false;
			}
		}
		return result;

	}

}
