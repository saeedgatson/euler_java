// The first two consecutive numbers to have two distinct prime factors are:
// 14 = 2 × 7
// 15 = 3 × 5
// The first three consecutive numbers to have three distinct prime factors are:
// 644 = 2² × 7 × 23
// 645 = 3 × 5 × 43
// 646 = 2 × 17 × 19.
// Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
import java.lang.*;

public class P047DistinctPrimesFactors {

  private static int primeFactorCount(long number) {

    int count = 0;
		for (int i = 2, end = (int) Math.sqrt(number); i <= end; i++) {
			if (number % i == 0) {
        while (number % i == 0) {
          number /= i;
        }
				count++;
				end = (int) Math.sqrt(number);
			}
		}

		if (number > 1) {
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    int count = 0;
    int itr = 1;

    while(count != 4) {
      if(primeFactorCount(itr) != 4) {
        count = 0;
      } else {
        count +=1;
      }
      itr += 1;
    }

    System.out.format("The first of four consecutive intergers to have four distinct prime factors is %d.%n", itr - 4);
  }
}
