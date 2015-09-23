// It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
// Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
import java.util.*;

public class P052PermutedMultiples {

  public static boolean isPermutedMultiples(int number) {
    char[] chars = String.valueOf(number).toCharArray();
    Arrays.sort(chars);
    String check = new String(chars);

    for(int multiple = 2; multiple < 6; multiple++) {
      chars = String.valueOf(multiple * number).toCharArray();
      Arrays.sort(chars);
      String check2 = new String(chars);
      if(!check.equals(check2)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int itr = 100000;
    while(true) {
      if(isPermutedMultiples(itr)) {
        System.out.format("The smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits is %d.%n", itr);
        break;
      }
      itr++;
    }
  }
}
