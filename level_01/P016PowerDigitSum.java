// 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
// What is the sum of the digits of the number 2^1000?
import java.math.*;

public class P016PowerDigitSum {
    public static void main(String[] args) {
        BigInteger two = new BigInteger("2");
        BigInteger number = two.pow(1000);
        System.out.println("The sum of digits for 2^1000 is : " + sumDigits(number));
    }

    private static BigInteger sumDigits(BigInteger digits) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger ten = new BigInteger("10");

        while ( digits != BigInteger.ZERO ) {
          sum = sum.add(digits.mod(ten));
          digits = digits.divide(ten);
        }
        return sum;
    }
}
