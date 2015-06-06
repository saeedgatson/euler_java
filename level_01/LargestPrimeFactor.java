public class LargestPrimeFactor {
  public static void main (String [] args) {
    LargestPrimeFactor primeFactor = new LargestPrimeFactor();
    System.out.println(primeFactor.largestPrimeGivenList(13195));
  }

  private int largestPrimeGivenList(int number) {
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
