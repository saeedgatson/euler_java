// n! means n × (n − 1) × ... × 3 × 2 × 1
// For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
// digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
// Find the sum of the digits in the number 100!
import java.math.*;

public class P020FactorialDigitSum {

  public static void main(String[] args) {
    System.out.println("The sum of digits in the factorial of 100 is " + sumDigits(factorial100()));

  }

  private static BigInteger factorial100() {
    BigInteger sum = BigInteger.ONE;
    BigInteger i = BigInteger.ONE;
    BigInteger hundred = new BigInteger("100");

    while(!i.equals(hundred)) {
      sum = sum.multiply(i);
      i = i.add(BigInteger.ONE);
    }
    return sum;
  }

  private static BigInteger sumDigits(BigInteger number) {
    BigInteger sum = BigInteger.ZERO;
    BigInteger ten = new BigInteger("10");

    while(!number.equals(BigInteger.ZERO)) {
      sum = sum.add(number.mod(ten));
      number = number.divide(ten);
    }
    return sum;
  }
}
