package example.date_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodAndDuration {

	public static void main(String[] args) {
		durationExample(); // Durations - Measures time in seconds and nanoseconds.
		periodExample(); // Period – Measures time in years, months and days.
	}

	public static void durationExample() {
		Duration oneHours = Duration.ofHours(1);
		System.out.println(oneHours.getSeconds() + " seconds");

		Duration oneHours2 = Duration.of(1, ChronoUnit.HOURS);
		System.out.println(oneHours2.getSeconds() + " seconds");

		// Test Duration.between
		System.out.println("\n--- Duration.between --- ");

		LocalDateTime oldDate = LocalDateTime.of(2016, Month.AUGUST, 31, 10, 20, 55);
		LocalDateTime newDate = LocalDateTime.of(2016, Month.NOVEMBER, 9, 10, 21, 56);

		System.out.println(oldDate);
		System.out.println(newDate);

		// count seconds between dates
		Duration duration = Duration.between(oldDate, newDate);
		System.out.println(duration.getSeconds() + " seconds");
	}

	public static void periodExample() {
		System.out.println("--- Examples --- ");

		Period tenDays = Period.ofDays(10);
		System.out.println(tenDays.getDays()); // 10

		Period oneYearTwoMonthsThreeDays = Period.of(1, 2, 3);
		System.out.println(oneYearTwoMonthsThreeDays.getYears()); // 1
		System.out.println(oneYearTwoMonthsThreeDays.getMonths()); // 2
		System.out.println(oneYearTwoMonthsThreeDays.getDays()); // 3

		System.out.println("\n--- Period.between --- ");
		LocalDate oldDate = LocalDate.of(1982, Month.AUGUST, 31);
		LocalDate newDate = LocalDate.of(2016, Month.NOVEMBER, 9);

		System.out.println(oldDate);
		System.out.println(newDate);

		// check period between dates
		Period period = Period.between(oldDate, newDate);
		System.out.println(String.format("%dyears, %dmonth, %days", period.getYears(), period.getMonths(), period.getDays()));
	}

}
