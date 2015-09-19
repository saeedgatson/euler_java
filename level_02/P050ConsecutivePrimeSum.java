// The prime 41, can be written as the sum of six consecutive primes:
// 41 = 2 + 3 + 5 + 7 + 11 + 13
// This is the longest sum of consecutive primes that adds to a prime below one-hundred.
// The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
// Which prime, below one-million, can be written as the sum of the most consecutive primes?

public class P050ConsecutivePrimeSum {
  private static final int LIMIT = 1000000;
  private static boolean[] isPrime = listPrimality(LIMIT);
  private static int[] primes = listPrimes(LIMIT);

  private static boolean[] listPrimality(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Negative array size");
		boolean[] result = new boolean[n + 1];
		if (n >= 2)
			result[2] = true;
		for (int i = 3; i <= n; i += 2)
			result[i] = true;

		for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
			if (result[i]) {
				for (int j = i * i; j <= n; j += i << 1)
					result[j] = false;
			}
		}
		return result;
	}

  private static int[] listPrimes(int n) {
		boolean[] isprime = listPrimality(n);
		int count = 0;
		for (boolean b : isprime) {
			if (b)
				count++;
		}

		int[] result = new int[count];
		for (int i = 0, j = 0; i < isprime.length; i++) {
			if (isprime[i]) {
				result[j] = i;
				j++;
			}
		}
		return result;
	}

  public static void main(String[] args) {
    int sum = 0;
    int consecutive = 0;
    int answer = 0;

    for(int start = 0; start < primes.length; start++) {
      //if(isPrime[start] != true) continue;
      sum = 0;//start;
      int ctr = 0;

      for(int stop = start + 1; stop < primes.length; stop++) {
        sum += primes[stop];

        if(sum >= LIMIT) {
          break;
        }

        ctr += 1;
        if(isPrime[sum] && ctr > consecutive) {
          consecutive = ctr;
          answer = sum;
        }
      }
    }
    System.out.format("The max consecutive primes is %d.%nFor the number %d.%n", consecutive, answer);
  }
}
