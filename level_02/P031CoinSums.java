// In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
// 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
// It is possible to make £2 in the following way:
// 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
// How many different ways can £2 be made using any number of coins?

public class P031CoinSums {
  private static int number = 200;
  private static int[] currency = {1,2,5,10,20,50,100,200};

  private static int count(int[] currency, int coins, int number) {
    if(number == 0) return 1;
    if(number < 0) return 0;
    if(coins <= 0 && number >= 1) return 0;

    return count(currency, coins - 1, number) + count(currency, coins, number - currency[coins - 1]);
  }

  public static void main(String[] args) {
    System.out.println("£2 can be made using any number of coins " + count(currency, currency.length, number) + " times.");
  }
}
