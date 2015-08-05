class P005SmallestMultiple {
  public static void main(String[] args) {
    P005SmallestMultiple smallMulti = new P005SmallestMultiple();

    System.out.println("Smallest multiple for 1 - 10 is : " + smallMulti.bruteForce(1, 10));

    System.out.println("Smallest multiple for 1 - 20 is : " + smallMulti.bruteForce(1, 20));
  }

  private int bruteForce(int start, int end) {
    int number = start;
    while(true) {
      for(int j = start; j <= end ; j++) {
        if(number % j != 0) {
          number++;
          break;
        }

        if(j == end) {
          return number;
        }
      }
    }
  }
}
