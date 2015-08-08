// Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
// How many such routes are there through a 20×20 grid?

import java.math.BigInteger;

class P015LatticePaths {
  public static void main(String args[]) {
        int moves = 40;
        int rights = 20;
        System.out.println(combination(moves, rights));
    }

    public static BigInteger factorial( int n1 )
    {
        BigInteger n = BigInteger.ONE;
        for (int i = 1; i <= n1; i ++) {
            n = n.multiply(BigInteger.valueOf(i));
        }
        return n;
    }

    public static BigInteger combination(int n, int r) {
      return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }
}
