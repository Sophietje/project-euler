import java.time.LocalDate;

public class Problem19 {
    LocalDate sunday;

    public static void main(String[] args) {
        int total = 0; // Count for number of sundays on the first of the month
        LocalDate sunday = LocalDate.of(1901, 1, 6);
        while (sunday.getYear() < 2001) {
            sunday = sunday.plusDays(7);
            System.out.println(sunday);
            if (sunday.getDayOfMonth() == 1) {
                total++;
            }
        }
        System.out.println("Number of sundays on the first of the month during the twentieth century: "+total);
    }
}
