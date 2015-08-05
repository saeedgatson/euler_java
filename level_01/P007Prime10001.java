import java.lang.Math;

class P007Prime10001 {
  public static void main (String[] args) {
    P007Prime10001 primes = new P007Prime10001();
    int value = 2;

    for(int i = 2, j = 0; j < 10001; i++ ) {
      if(primes.isPrime(i)) {
        value = i;
        j++;
      }
    }

    System.out.println("The 10001 prime number is : " + (value));
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
