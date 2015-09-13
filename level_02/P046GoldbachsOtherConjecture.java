// It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
// 9 = 7 + 2×1^2
// 15 = 7 + 2×2^2
// 21 = 3 + 2×3^2
// 25 = 7 + 2×3^2
// 27 = 19 + 2×2^2
// 33 = 31 + 2×1^2
// It turns out that the conjecture was false.
// What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

public class P046GoldbachsOtherConjecture {

  private static boolean isPrime(int number) {
    if(number < 2) return false;
    Double rootDbl = Math.sqrt(number);
    long root = rootDbl.longValue();
    for(long i = 2; i <= root; i++) {
      if(number % i == 0) {
        return false;
      }
    }
    return true;
  }

  private static boolean isGoldbach(int number) {
		if (number % 2 == 0 || isPrime(number))
			return true;

		// Now number is an odd composite number
		for (int i = 1; i * i * 2 <= number; i++) {
			if (isPrime(number - i * i * 2))
				return true;
		}
		return false;
	}

  public static void main(String[] args) {
    int i = 9;
    while(true) {
      if (!isGoldbach(i)) {
        System.out.format("The smallest odd composite that cannot be written as the sum of a prime and twice a square is %d.%n", i);
        break;
      }
      i += 2;
    }
  }
}
