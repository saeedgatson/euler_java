// It is possible to show that the square root of two can be expressed as an infinite continued fraction.
// √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
// By expanding this for the first four iterations, we get:
// 1 + 1/2 = 3/2 = 1.5
// 1 + 1/(2 + 1/2) = 7/5 = 1.4
// 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
// 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
// The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.
// In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?

import java.math.BigInteger;

public class P057SquareRootConvergents {
  public static void main(String[] args) {
    int result = 0;

    BigInteger denominator = new BigInteger("2");
    BigInteger numerator = new BigInteger("3");

    for (int i = 1; i < 1000; i++) {
      BigInteger two = new BigInteger("2");
      numerator = numerator.add(two.multiply(denominator));
      denominator = numerator.subtract(denominator);
      if ( numerator.toString().length() > denominator.toString().length() ) result++;
    }
    System.out.format("In the first one-thousand expansions, %d fractions contain a numerator with more digits than denominator.%n", result);
  }
}
