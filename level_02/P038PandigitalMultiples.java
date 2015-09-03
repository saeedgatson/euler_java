import java.util.*;

public class P038PandigitalMultiples {
  public static int getPandigital(int multiplicand) {
    int number = 1;
    String check = "";
    String smashed = "";
    while(check.length() < 9) {
      int product = multiplicand * number;
      smashed += Integer.toString(product);
      char[] chars = smashed.toCharArray();
      Arrays.sort(chars);
      check = new String(chars);
      if(check.length() == 9 && check.equals("123456789")){
        return Integer.parseInt(smashed);
      }
      number++;
    }
    return 0;
  }
  public static void main(String[] args) {
    int max = 999999;
    int largest = 1;

    for(int i = 0; i <= max; i++) {
      int check = getPandigital(i);
      if(check >= largest) {
        largest = check;
      } else if(check > 99999999) {
        break;
      }
    }

    System.out.println(largest);
  }
}
