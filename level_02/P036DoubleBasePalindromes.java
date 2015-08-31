// The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
// Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
// (Please note that the palindromic number, in either base, may not include leading zeros.)
import java.lang.*;

public class P036DoubleBasePalindromes {
  public static boolean isDoublePalindrome(int number){
    String numberString = Integer.toString(number);
    String reverseNumber = new StringBuffer(numberString).reverse().toString();
    String binaryNumber = Integer.toBinaryString(number);
    String reverseBinaryNumber = new StringBuffer(binaryNumber).reverse().toString();
    return reverseNumber.equals(numberString) && reverseBinaryNumber.equals(binaryNumber);
  }
  public static void main(String[] args) {
    int total = 0;
    for(int i = 1; i < 1000000; i++) {
      if(isDoublePalindrome(i)){
        total += i;
      }
    }
    System.out.println("Total sum is : " + total);
  }
}
