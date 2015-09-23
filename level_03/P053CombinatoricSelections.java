// There are exactly ten ways of selecting three from five, 12345:
// 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
// In combinatorics, we use the notation, 5C3 = 10.
// In general, nCr =	n! / r!(n−r)! , where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
// It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
// How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?

public class P053CombinatoricSelections {

  private static int factorial(int x) {
    if (x == 0) return 1;

    int y = x;
    for (int i = 1; i < x; i++) {
        y *= i;
    }
    return y;
  }

  private static int combinatorics(int n, int r) {
    // System.out.format("n is %d, and r is %d.%n", n, r);
    // System.out.format("fac(n) is %d, fac(r) is %d, and fac(n - r) is %d.%n", factorial(n), factorial(r), factorial(n - r));
    return factorial(n) / (factorial(r) * factorial(n - r));
  }

  public static void main(String[] args) {
    int count = 0;
    for(int n = 1; n < 100; n++) {
      for(int r = 0; r <= 1; r++) {
        if(combinatorics(n, r) > 1000000) {
          count++;
        }
      }
    }
  }
}
