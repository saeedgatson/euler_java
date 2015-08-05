class P002EvenFibonacciNumbers {
  private static int sum = 0;
  private static int maxValue = 4000000;

  public static void main (String[] args) {
    int iterator = 0;
    int sequenceValue = 0;

    while (sequenceValue < maxValue) {
      sequenceValue = fib(iterator);
      if (sequenceValue % 2 == 0) {
        sum = sum + sequenceValue;
      }
      iterator++;
    }

    System.out.println(sum);
  }

  public static int fib(int number) {
    if (number == 0) {
      return 0;
    }
    else if (number == 1) {
      return 1;
    }

    return fib(number - 1) + fib(number - 2);
  }
}
