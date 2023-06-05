import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Test {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        // Get the first day of the week
        LocalDate firstDayOfWeek = dateTime.toLocalDate()
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        System.out.println(firstDayOfWeek.atStartOfDay());

    }
}
