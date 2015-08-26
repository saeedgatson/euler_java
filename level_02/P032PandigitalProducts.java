// We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
// The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
// Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
// HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
import java.util.*;

public class P032PandigitalProducts {
  private static HashSet<Integer> set = new HashSet<Integer>();
  public static boolean isPandigital(int multiplicand, int multiplier) {
    int product = multiplicand * multiplier;
    String smashed = String.valueOf(multiplier) + String.valueOf(multiplicand) + String.valueOf(product);
    char[] chars = smashed.toCharArray();
    Arrays.sort(chars);
    String sorted = new String(chars);
    if(sorted.length() == 9 && sorted.equals("123456789")){
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    for(int i = 1; i < 9999; i++) {
      for(int j = i + 1; j < 9999; j++) {
        int product = i * j;
        if(isPandigital(i, j)){
          set.add(product);
        }
        else if (product > 99999999 ) {
          break;
        }
      }
    }
    int sum = 0;
    for (Integer n : set) {
      sum += n;
    }

    System.out.println("The sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 is : " + sum);
  }
}
