// The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
// There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
// What 12-digit number do you form by concatenating the three terms in this sequence?

import java.util.*;

public class P049PrimePermutation {
  private static final int LIMIT = 10000;
  private static boolean[] isPrime = listPrimality(LIMIT - 1);

	private static boolean[] listPrimality(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Negative array size");
		boolean[] result = new boolean[n + 1];
		if (n >= 2)
			result[2] = true;
		for (int i = 3; i <= n; i += 2)
			result[i] = true;

		for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
			if (result[i]) {
				for (int j = i * i; j <= n; j += i << 1)
					result[j] = false;
			}
		}
		return result;
	}

  public static String getSorted(int number) {
    char[] chars = String.valueOf(number).toCharArray();
    Arrays.sort(chars);
    String sorted = new String(chars);
    return sorted;
  }

  private static boolean isUnusual(int number) {
    int check1 = number + 3330;
    int check2 = number + 6660;
    if(isPrime[check1] == false || isPrime[check2] == false || number == 1487) {
      return false;
    }
    String numberSorted = getSorted(number);
    String check1Sorted = getSorted(check1);
    String check2Sorted = getSorted(check2);
    if(numberSorted.equals(check1Sorted) && numberSorted.equals(check2Sorted)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    for (int itr = 1000; itr < LIMIT; itr++) {
      if (isPrime[itr]) {
        if (isUnusual(itr)) {
					System.out.format("The 12-digit number that's formed by concatenating the three terms in this sequence is %d%d%d.%n", itr, itr + 3330, itr + 6660);
          break;
        }
			}
		}
  }
}
