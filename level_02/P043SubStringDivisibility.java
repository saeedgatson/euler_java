// The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
// Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
// d2d3d4=406 is divisible by 2
// d3d4d5=063 is divisible by 3
// d4d5d6=635 is divisible by 5
// d5d6d7=357 is divisible by 7
// d6d7d8=572 is divisible by 11
// d7d8d9=728 is divisible by 13
// d8d9d10=289 is divisible by 17
// Find the sum of all 0 to 9 pandigital numbers with this property.

import java.util.*;

public class P043SubStringDivisibility {
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

  public static boolean isInteresting(String numStr) {
    if(Integer.parseInt(numStr.substring(1, 4)) % 2 != 0) return false;
    if(Integer.parseInt(numStr.substring(2, 5)) % 3 != 0) return false;
    if(Integer.parseInt(numStr.substring(3, 6)) % 5 != 0) return false;
    if(Integer.parseInt(numStr.substring(4, 7)) % 7 != 0) return false;
    if(Integer.parseInt(numStr.substring(5, 8)) % 11 != 0) return false;
    if(Integer.parseInt(numStr.substring(6, 9)) % 13 != 0) return false;
    if(Integer.parseInt(numStr.substring(7, 10)) % 17 != 0) return false;
    return true;
  }

  public static void main(String[] args) {
    permutation("", digits);
    System.out.println(isInteresting("1406357289"));
    long sum = 0;
    for(String number : permutationList){
      if(isInteresting(number)) {
        sum += Long.parseLong(number);
      }
    }
    System.out.println("The sum of all 0 to 9 pandigital numbers with an interesting property is " + sum);
  }
}
