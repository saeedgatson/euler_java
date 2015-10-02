// A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.
// Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?

import java.math.BigInteger;

public class P056PowerfulDigitSum {

  private static int sumDigits(BigInteger number) {
    String digits = number.toString();
    int sum = 0;

    for(int i = 0; i < digits.length(); i++) {
      int digit = (int) (digits.charAt(i) - '0');
      sum = sum + digit;
    }

    return sum;
  }

  public static void main(String[] args) {
    int largest = 0;
    int sum = 0;

    for(int a = 1; a <= 99; a++) {
      for(int b = 1; b <= 99; b++) {
        BigInteger bigA = new BigInteger(String.valueOf(a));
        sum = sumDigits(bigA.pow(b));
        largest = sum > largest ? sum : largest;
      }
    }

    System.out.format("Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum is %d.%n", largest);
  }
}
