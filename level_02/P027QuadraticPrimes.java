// Euler discovered the remarkable quadratic formula:
// n² + n + 41
// It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
// The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, −79 and 1601, is −126479.
// Considering quadratics of the form:
// n² + an + b, where |a| < 1000 and |b| < 1000
// where |n| is the modulus/absolute value of n
// e.g. |11| = 11 and |−4| = 4
// Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.

public class P027QuadraticPrimes {
  private static int chain = 0;
  private static int a = 0;
  private static int b = 0;

  public static boolean isPrime(int number) {
    if(number < 1) return false;
    if(number % 2 == 0) return false;
    for(int i = 3; i * i <= number; i += 2) {
        if(number % i == 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    for(int i = -1000; i < 1000; i++) {
      for(int j = 1; j < 1000; j++) {
        int n = 0;
        while(isPrime((n * n) + (i * n) + j)) {
          n += 1;
        }

        if(n > chain) {
          chain = n;
          a = i;
          b = j;
        }
      }
    }
    System.out.println("The product of the coefficients, "+ a +" and "+ b +" is "+ a * b +", which produces "+ chain +" primes in a row.");
  }
}
