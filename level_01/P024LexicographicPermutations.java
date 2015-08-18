// A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
// 012   021   102   120   201   210
// What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
import java.util.*;

public class P024LexicographicPermutations {
  private static String digits = "0123456789";
  private static ArrayList<String> permutationList = new ArrayList<String>();

  private static void permutation(String prefix, String str) {
    int n = str.length();
    if(n == 0) {
      permutationList.add(prefix);
    }
    else {
      for (int i = 0; i < n; i++) {
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
      }
    }
  }

  public static void main(String args[]) {
    permutation("", digits);
    System.out.println("The millionth lexicographic permutation is " + permutationList.get(999999));
  }
}
