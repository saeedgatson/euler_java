// We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
// What is the largest n-digit pandigital prime that exists?
import java.util.*;

public class P041PandigitalPrime {
  private static boolean isPrime(int number) {
    if(number < 2) return false;
    Double rootDbl = Math.sqrt(number);
    long root = rootDbl.longValue();
    for(long i = 2; i <= root; i++) {
      if(number % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPandigitalPrime(int number) {
    if(!isPrime(number)) return false;

    char[] chars = String.valueOf(number).toCharArray();
    Arrays.sort(chars);
    String sorted = new String(chars);
    if(sorted.equals("1234567")){
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int largest = 1;
    for(int i = 10; i < 7654321; i++) {
      if(isPandigitalPrime(i) && i > largest) {
        largest = i;
      }
    }
    System.out.println("The largest n-digit pandigital prime that exists is " + largest);
  }
}
