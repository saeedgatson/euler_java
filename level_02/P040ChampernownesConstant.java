// An irrational decimal fraction is created by concatenating the positive integers:
// 0.123456789101112131415161718192021...
// It can be seen that the 12th digit of the fractional part is 1.
// If dn represents the nth digit of the fractional part, find the value of the following expression.
// d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

public class P040ChampernownesConstant {

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i < 1000000; i++) {
      sb.append(i);
    }
    String decimal = sb.toString();
    System.out.println(Character.getNumericValue(decimal.charAt(0)) * Character.getNumericValue(decimal.charAt(9)) * Character.getNumericValue(decimal.charAt(99)) * Character.getNumericValue(decimal.charAt(999)) * Character.getNumericValue(decimal.charAt(9999)) * Character.getNumericValue(decimal.charAt(99999)) * Character.getNumericValue(decimal.charAt(999999)));
  }
}
