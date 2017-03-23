package example.date_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersExample {

	public static void main(String[] args) {
		temporalAdjusters();
		System.out.println();
		customTemporalAdjuster();
	}

	public static void temporalAdjusters() {
		LocalDate localDate = LocalDate.now();
		System.out.println("current date : " + localDate);

		LocalDate with = localDate.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("firstDayOfMonth : " + with);

		LocalDate with1 = localDate.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("lastDayOfMonth : " + with1);

		LocalDate with2 = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println("next monday : " + with2);

		LocalDate with3 = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println("firstDayOfNextMonth : " + with3);
	}

	public static void customTemporalAdjuster() {
		LocalDate localDate = LocalDate.now();
		System.out.println("current date : " + localDate);

		localDate = localDate.with(new NextChristmas());
		System.out.println("Next Christmas : " + localDate);

		localDate = localDate
				.with(temporal -> temporal.with(ChronoField.MONTH_OF_YEAR, 12).with(ChronoField.DAY_OF_MONTH, 25));
		System.out.println("Next Christmas : " + localDate);
	}
}

class NextChristmas implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		// 지난 날일 경우 체크하는 로직 필요
		return temporal.with(ChronoField.MONTH_OF_YEAR, 3).with(ChronoField.DAY_OF_MONTH, 14);
	}

}
