// Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
// If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
// For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
// Evaluate the sum of all the amicable numbers under 10000.

public class P021AmicableNumbers {
  public static void main(String[] args) {
    int amicableSum = 0;
    for(int i = 2; i < 10000; i++) {
      if(isAmicable(i)) {
        amicableSum += i;
      }
    }
    System.out.println("The sum of all amicable numbers under 10000 is " + amicableSum);
  }

  public static int sumOfDivisors(int number) {
    int sum = 0;
    for(int i = 1; i < number; i++) {
      if(number % i == 0) {
        sum += i;
      }
    }
    return sum;
  }

  public static boolean isAmicable(int number) {
    int sumA = sumOfDivisors(number);
    int sumB = sumOfDivisors(sumA);
    if(number == sumB && sumA != sumB) {
      return true;
    }
    return false;
  }
}
