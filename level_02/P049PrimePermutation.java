// The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
// There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
// What 12-digit number do you form by concatenating the three terms in this sequence?

import java.util.*;

public class P049PrimePermutation {
  public static boolean isPrime(int number) {
    if(number < 1) return false;
    if(number % 2 == 0) return false;
    for(int i = 3; i * i <= number; i += 2) {
        if(number % i == 0) return false;
    }
    return true;
  }

  public static String getSorted(int number) {
    char[] chars = String.valueOf(number).toCharArray();
    Arrays.sort(chars);
    String sorted = new String(chars);
    return sorted;//Integer.parseInt(sorted);
  }

  private static boolean isUnusual(int number) {
    int check1 = number + 3330;
    int check2 = number + 6660;
    if(!isPrime(check1) && !isPrime(check2)) {
      return false;
    }
    String numberSorted = getSorted(number);
    String check1Sorted = getSorted(check1);
    String check2Sorted = getSorted(check2);
    if(numberSorted.equals(check1Sorted) && numberSorted.equals(check2Sorted)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int itr = 99;
    int answer = 0;
    while(true) {
      if(itr == 1487) {
        continue;
      }

      if(isUnusual(itr)){
        answer = itr;
        break;
      }
      itr++;
    }
    System.out.format("%d%d%d.%n",answer, answer + 3330, answer + 6660);
  }
}
