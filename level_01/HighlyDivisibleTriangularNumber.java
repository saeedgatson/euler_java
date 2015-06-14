class HighlyDivisibleTriangularNumber {
  public static void main(String[] args) {
    int divisors = 500;
    int i = 1;

    while(true) {
      int triangle = 0;

      for(int j = 1; j <= i; j++) {
        triangle = triangle + j;
      }

      if(numOfDivisors(triangle) >= divisors) {
        System.out.printf("%d is the first triangle number to have over %d divisors.%n", triangle, divisors);
        break;
      }
      i++;
    }
  }

  public static int numOfDivisors(int number) {
    int count = 0;
    int max = (int) number / 2;
    for(int i = 2; i <= max; i++) {
      if (number % i == 0) {
        count += 2;
        max = (number / i) - 1;
      }
    }
    return count;
  }
}
