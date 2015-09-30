// By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
// By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.
// Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.

public class P051PrimeDigitReplacements {

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

  private int[] fillPattern(int[] pattern, int number) {
    int[] filledPattern = new int[pattern.length];
    int temp = number;

    for(int i = filledPattern.length - 1; 0 <= i; i--) {
      if(pattern[i] == 1) {
        filledPattern[i] = temp % 10;
        temp /= 10;
      }
      else {
        filledPattern[i] = -1;
      }
    }
    return filledPattern;
  }

  private int generateNumber(int repNumber, int[] filledPattern) {
    int temp = 0;
    for(int i = filledPattern.length - 1; 0 <= i; i--) {
      temp = temp * 10;
      temp += (filledPattern[i] == -1) ? repNumber : filledPattern[i];
    }

    return temp;
  }

  private int familySize(int repeatingNumber, int[] pattern) {
       int familySize = 1;

       for (int i = repeatingNumber + 1; i < 10; i++) {
           if (isPrime(generateNumber(i, pattern))) familySize++;
       }

       return familySize;
   }

  public static void main(String[] args) {
    boolean[][] fiveDigitPattern = {
      {true, false, false, false, true},
      {false, true, false, false, true},
      {false, false, true, false, true},
      {false, false, false, true, true},
    };

    boolean[][] sixDigitPattern = {
      {true, true, false, false, false, true},
      {true, false, true, false, false, true},
      {true, false, false, true, false, true},
      {true, false, false, false, true, true},
      {false, true, true, false, false, true},
      {false, true, false, true, false, true},
      {false, true, false, false, true, true},
      {false, false, true, true, false, true},
      {false, false, true, false, true, true},
      {false, false, false, true, true, true},
    };

    int result = 0;

    for(int i = 11; i < 1000; i += 2) {
      if(i % 5 == 0) continue;

      boolean[][] patterns = (i < 100) ? fiveDigitPattern : sixDigitPattern;

      for(int j = 0; j < patterns.length; j++) {
        for (int k = 0; k <=2; k++ ) {
          if (patterns[j][0] == true && k == 0) continue;

          boolean[] pattern = fillPattern(patterns[j], i);
          int candidate = generateNumber(k, pattern);

          if(candidate < result && isPrime(candidate)) {
            if (familySize(k, pattern) == 8) {
              result = candidate;
            }
            break;
          }
        }
      }
    }
  }
}
