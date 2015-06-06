public class LargestPrimeFactor {
  public static void main (String [] args) {
    LargestPrimeFactor primeFactor = new LargestPrimeFactor();
    System.out.println("Largest Prime Factor of 600851475143 is: " + primeFactor.largestPrimeFactor(600851475143L));
  }

  private int largestPrimeFactor(long number) {
    long n = number;
    int highest = 2;
    for (int i = 2; i <= n; i++) {
      while (n % i == 0) {
        if(highest < i) {
          highest = i;
        }
        n /= i;
      }
    }
    return highest;
  }

  private int largestPrimeFactorGivenList(int number) {
    int[] primeList = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71};
    int highest = 2;

    for (int i = 0; i < primeList.length && primeList[i] < number; i++) {
      if( number % primeList[i] == 0) {
        highest = primeList[i];
      }
    }
    return highest;
  }
}
