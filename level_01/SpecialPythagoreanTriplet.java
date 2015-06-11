import java.lang.Math;

class SpecialPythagoreanTriplet {
  public static void main (String[] args) {
    int a = 0 , b = 0, c = 0;
    int sum = 1000;
    boolean isFound = false;

    for (a = 1; a < sum / 3; a++) {
      for (b = a; b < sum / 2; b++) {
        c = sum - a -b;

        if (a * a + b * b == c * c) {
          isFound = true;
          break;
        }
      }

      if(isFound) {
        break;
      }
    }

    System.out.printf("Triple is %d, %d, %d, and the sume is %d%n", a, b, c, a + b + c);
    System.out.printf("The product is %d%n", a * b * c);
  }
}
