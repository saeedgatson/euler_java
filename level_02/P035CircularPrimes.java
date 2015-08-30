// The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
// There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
// How many circular primes are there below one million?

import java.util.*;

public class P035CircularPrimes {
  private static final int LIMIT = (int) Math.pow(10, 6);
  private static boolean[] isPrime = listPrimality(LIMIT - 1);

	private static boolean[] listPrimality(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Negative array size");
		boolean[] result = new boolean[n + 1];
		if (n >= 2)
			result[2] = true;
		for (int i = 3; i <= n; i += 2)
			result[i] = true;
		// Sieve of Eratosthenes
		for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
			if (result[i]) {
				// Note: i * i does not overflow
				for (int j = i * i; j <= n; j += i << 1)
					result[j] = false;
			}
		}
		return result;
	}

  private static boolean isCircularPrime(int n) {
		String s = Integer.toString(n);
		for (int i = 0; i < s.length(); i++) {
			if (!isPrime[Integer.parseInt(s.substring(i) + s.substring(0, i))])
				return false;
		}
		return true;
	}

  public static void main(String args[]) {
    int count = 0;
		for (int i = 0; i < isPrime.length; i++) {
			if (isCircularPrime(i))
				count++;
		}
		System.out.println("Number of circular primes below one million is " + Integer.toString(count));
  }
}
