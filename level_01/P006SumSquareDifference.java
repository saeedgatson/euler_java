class P006SumSquareDifference {
  public static void main (String[] args) {
    P006SumSquareDifference sumSquareDiff = new P006SumSquareDifference();

    System.out.println("The sum of square difference for first 10 natrual numbers is : " + (sumSquareDiff.squareOfSum(1,10) - sumSquareDiff.sumOfSquares(1,10)));

    System.out.println("The sum of square difference for first 100 natrual numbers is : " + (sumSquareDiff.squareOfSum(1,100) - sumSquareDiff.sumOfSquares(1,100)));
  }

  private int sumOfSquares(int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += (i * i);
    }
    return sum;
  }

  private int squareOfSum(int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += i;
    }
    return sum * sum;
  }
}
