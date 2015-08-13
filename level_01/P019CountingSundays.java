// How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
import java.time.*;

public class P019CountingSundays {
  public static void main(String[] args) {
    int sundayCount = 0;
    LocalDate start = LocalDate.of(1901, 1, 1);
    LocalDate end = LocalDate.of(2000, 12, 31);

    for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
      if(DayOfWeek.SUNDAY == date.getDayOfWeek() && date.getDayOfMonth() == 1)
        sundayCount++;
    }

    System.out.println(sundayCount +" Sundays fell on the first of the month during the twentieth century.");
  }
}
