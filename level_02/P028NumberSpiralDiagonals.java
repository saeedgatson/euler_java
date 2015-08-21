// Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
//
// 21 22 23 24 25
// 20  7  8  9 10
// 19  6  1  2 11
// 18  5  4  3 12
// 17 16 15 14 13

// It can be verified that the sum of the numbers on the diagonals is 101.
// What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

public class P028NumberSpiralDiagonals {
  public static void main(String[] args) {
    int sum = 1;
    int stop = 500;
    for(int n = 1; n <= stop; n++) {
      int upRight = (int) Math.pow((2 * n) + 1, 2);
      int upLeft = upRight - 2 * n;
      int downLeft = upRight - 4 * n;
      int downRight = upRight - 6 * n;
      sum += upRight + upLeft + downLeft + downRight;
    }
    System.out.println("Sum of the numbers on the diagonals in a 1001 by 1001 spiral is " + sum);
  }
}
