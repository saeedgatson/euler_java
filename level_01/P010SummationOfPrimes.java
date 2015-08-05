class P010SummationOfPrimes {
  private static P010SummationOfPrimes summation = new P010SummationOfPrimes();

  public static void main (String[] args) {
    System.out.printf("Sum of all primes below %d is %d%n", 10, summation.getSumOfPrimes(10));
    System.out.printf("Sum of all primes below %d is %d%n", 2000000, summation.getSumOfPrimes(2000000));
  }

  private long getSumOfPrimes(int max) {
    long totalSum = 0;
    for(int i = 2; i < max; i++ ) {
      if(summation.isPrime(i)) {
        totalSum += i;
      }
    }

    return totalSum;
  }

  private boolean isPrime(int number) {
    Double rootDbl = Math.sqrt(number);
    int root = rootDbl.intValue();
    for(int i = 2; i <= root; i++) {
      if(number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
