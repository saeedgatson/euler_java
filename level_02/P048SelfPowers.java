// The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
// Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
import java.lang.*;
import java.math.*;

public class P048SelfPowers {
  public static void main(String[] args) {
    int max = 1000;
    BigInteger result = BigInteger.ZERO;
    BigInteger modulus = BigInteger.valueOf(10000000000L);
    for(int i = 1; i <= max; i++) {
      BigInteger bigI = BigInteger.valueOf(i);
      result = result.add(bigI.pow(i));
    }
    System.out.format("The last ten digits of the series are %s.%n",result.mod(modulus).toString());
  }
}
