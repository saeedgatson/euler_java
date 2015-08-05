/*A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.*/

import java.lang.StringBuilder;

public class P004LargestPalindromeProduct {

  public static void main(String[] args) {
    P004LargestPalindromeProduct palindrome = new P004LargestPalindromeProduct();
    int largestPalindrome = 0;
    int product = 0;
    int num1 = 0;
    int num2 = 0;

    for (int i = 100; i < 1000; i++ ) {
      for (int j = 100; j < 1000; j++) {
        product = i * j;
        if(palindrome.isPalindrome(product)) {
          if(largestPalindrome < product) {
            num1 = i;
            num2 = j;
            largestPalindrome = product;
          }
        }
      }
    }

    System.out.println("Largest palindrome product for 3-digits is : " + largestPalindrome + " = " + num1 + " x " + num2);
  }

  private boolean isPalindrome(int number) {
    String numberString = Integer.toString(number);
    StringBuilder sb = new StringBuilder(numberString);
    sb.reverse();
    String reversedString = sb.toString();
    return numberString.equals(reversedString);
  }
}
