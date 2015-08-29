public class P034DigitFactorials {

  private static int factorial(int x) {
    if (x == 0) return 1;
    
    int y = x;
    for (int i = 1; i < x; i++) {
        y *= i;
    }
    return y;
  }

  public static void main(String[] args) {
    int result = 0;
    for (int i = 10; i < 2540161; i++) {
      int factorialSum = 0;
      int number = i;

      while (number > 0) {
        int d = number % 10;
        number /= 10;
        factorialSum += factorial(d);
      }

      if (factorialSum == i) {
          result += i;
      }
    }
    System.out.println(result);
  }
}
