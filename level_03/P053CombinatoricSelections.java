// There are exactly ten ways of selecting three from five, 12345:
// 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
// In combinatorics, we use the notation, 5C3 = 10.
// In general, nCr =	n! / r!(n−r)! , where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
// It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
// How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?

import java.math.BigInteger;

public class P053CombinatoricSelections {

  public static BigInteger factorial(int number) {
		BigInteger product = BigInteger.ONE;
		for (int i = 2; i <= number; i++)
			product = product.multiply(BigInteger.valueOf(i));
		return product;
	}

  private static BigInteger combinatorics(int n, int r) {
    return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
  }

  public static void main(String[] args) {
    BigInteger MILLION = BigInteger.valueOf(1000000);
    int count = 0;
    for(int n = 1; n <= 100; n++) {
      for(int r = 0; r <= n; r++) {
        if(combinatorics(n, r).compareTo(MILLION) > 0) {
          count++;
        }
      }
    }
    System.out.format("There are %d, not necessarily distinct, values of nCr, for 1 ≤ n ≤ 100, that are greater than one-million.%n" ,count);
  }
}
