// The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
// Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
// NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

public class P037TruncatablePrimes {
  private static boolean isTruncatablePrime(int number) {
    String numberString = Integer.toString(number);
    String reverseNumber = new StringBuffer(numberString).reverse().toString();

    for(int i = 0; i < numberString.length(); i++){
      if(!isPrime(Integer.parseInt(numberString.substring(i)))) {
        return false;
      }

      if(!isPrime(Integer.parseInt(reverseNumber.substring(i)))) {
        return false;
      }
    }
    return true;
  }

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

  public static void main(String[] args) {
    long sum = 0;
		for (int count = 0, n = 10; count < 11; n++) {
			if (isTruncatablePrime(n)) {
				sum += n;
				count++;
			}
		}
    System.out.println("The sum of the eleven truncatable primes is " + sum);
  }
}
