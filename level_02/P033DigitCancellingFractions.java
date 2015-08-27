// The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
// We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
// There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
// If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
import java.util.*;

public class P033DigitCancellingFractions {
  public static int numeratorProduct = 0;
  public static int denominatorProduct = 0;

  public static int curiousDivide(int n, int d) {
    String n_str = String.valueOf(n);
    String d_str = String.valueOf(d);
    String str = n_str + d_str;
    char removeValue = '\0';

    for (char c : str.toCharArray()) {
      System.out.println("char " + c);
      int count = str.length() - str.replace(c, '\0').length();
      System.out.println("count " + count);
      if(count == 2)
        removeValue = c;
    }

    System.out.println("remove " + removeValue);

    n_str = n_str.replace(removeValue, '\0');
    d_str = d_str.replace(removeValue, '\0');
    System.out.println("n_str " + n_str);
    System.out.println("d_str " + d_str);

    return Integer.parseInt(n_str) / Integer.parseInt(d_str);
  }

  public static void doWork(int n, int d) {
    if(n % 10 == 0 || d % 10 == 0) return;
    int c1 = n / d;
    int c2 = curiousDivide(n, d);
    System.out.println(c1);
    System.out.println(c2);
    if(c1 == c2) {
      numeratorProduct *= n;
      denominatorProduct *= d;
    }
  }

  public static void main(String[] args) {
    for(int n = 10; n <= 98; n++) {
      for(int d = n + 1; d <= 99; d++) {
        doWork(n, d);
      }
    }
    System.out.println(denominatorProduct);
    System.out.println(numeratorProduct);
  }
}
