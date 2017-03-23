package example.date_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import example.util.PrintUtil;

public class FormatLocalDateTime {

	public static void main(String[] args) {
		String strDate;
		DateTimeFormatter formatter;
		LocalDateTime localDateTime;

		// LocalDateTime + DateTimeFormatter
		localDateTime = LocalDateTime.now();
		PrintUtil.print("before", localDateTime.toString());

		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		PrintUtil.print("after", localDateTime.format(formatter));

		// String -> LocalDateTime
		strDate = "2016-11-09 10:30";
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		localDateTime = LocalDateTime.parse(strDate, formatter);

		System.out.println("Before : " + strDate);
		System.out.println("After  : " + localDateTime);
		System.out.println("After  : " + localDateTime.format(formatter));
	}

}
