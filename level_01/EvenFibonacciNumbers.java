class EvenFibonacciNumbers {
  public int sum;
  public static void main (String[] args) {
    for(int i = 2; i < 12; i++) {
      System.out.println(fib(i));
    }
  }

  public static int fib(int value) {
    if (value == 0) {
      return 0;
    }
    else if (value == 1) {
      return 1;
    }
    return fib(value - 1) + fib(value - 2);
  }
}
