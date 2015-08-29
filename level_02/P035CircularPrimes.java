// The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
// There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
// How many circular primes are there below one million?

import java.util.*;

public class P035CircularPrimes {
  public static boolean isPrime(int number) {
    if(number < 1) return false;
    if(number % 2 == 0) return false;
    for(int i = 3; i * i <= number; i += 2) {
        if(number % i == 0) return false;
    }
    return true;
  }

  private static boolean isCircularPime(String prefix, String str) {
    int n = str.length();
    if(n == 0) {
      if(!isPrime(Integer.parseInt(str))) return false;
    }
    else {
      for (int i = 0; i < n; i++) {
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
      }
    }
    return true;
  }

  public static void main(String args[]) {
    int count = 0;
    for(int i = 0; i < 1000000; i++){
      if(isCircularPime("", Integer.toString(i))) {
        count++;
      }
    }
    System.out.println(count);
  }
}
