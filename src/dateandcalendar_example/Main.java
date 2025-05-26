package dateandcalendar_example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	
	public static void main(String[] args) {
		
		// Instant 클래스
		// Instant 클래스는 특정 시점을 표현하기위한 클래스이다.
		Instant start = Instant.now();
		
		for (int i = 0; i < 10000; i++) {
			System.out.println("");
		}
		
		Instant end = Instant.now();
		
		// getEpochSecond() 메소드
		System.out.println("start.getEpochSecond() = " + start.getEpochSecond()); // 초단위 숫자
		System.out.println("end.getEpochSecond() = " + end.getEpochSecond()); // 초단위 숫자
		System.out.println("소요시간(초) = " + (end.getEpochSecond() - start.getEpochSecond())); // 0 // 0초 미만이기 때문
		
		// Duration
		// `java.time.Duration` 은 시간 차이를 표현하는 클래스이다.
		//`between` 메소드를 이용해 시간차를 저장한다.
		Duration duration1 = Duration.between(start, end);
		
		System.out.println("duration1 = " + duration1);
		System.out.println("duration1.toMillis() = " + duration1.toMillis()); // 밀리초 시간 단위
		System.out.println("duration1.toSeconds() = " + duration1.toSeconds()); // 초단위 시간
		
		// 날짜와 관련된 클래스
		// LocalDate 클래스
		// LocalDate 클래스 는 날짜 정보를 담고 있는 클래스이다.
		// LocalDate.now() 는 오늘 날짜를 리턴한다.
		LocalDate localDate1 = LocalDate.now();
		
		System.out.println("localDate1 = " + localDate1); // 오늘 날짜
		
		// LocalDate.of(year, month, day) 는 원하는 날을 지정할 수 있다.
		LocalDate localDate2 = LocalDate.of(2025, 01, 01);
		
		System.out.println("localDate2 = " + localDate2); // localDate2 = 2025-01-01
		
		// LocalDate 의 메소드
		System.out.println("localDate2.getYear() = " + localDate2.getYear()); // 2025
		System.out.println("localDate2.getMonth() = " + localDate2.getMonth()); // JANUARY
		System.out.println("localDate2.getMonth().getValue() = " + localDate2.getMonth().getValue()); // 1
		System.out.println("localDate2.getDayOfMonth() = " + localDate2.getDayOfMonth()); // 1
		System.out.println("localDate2.getDayOfWeek() = " + localDate2.getDayOfWeek()); // WEDNESDAY
		
		// LocalDate2 = 2025-01-01
		System.out.println("localDate2.plusYears(1) = " + localDate2.plusYears(1)); // 2026-01-01
		System.out.println("localDate2.plusMonths() = " + localDate2.plusMonths(1)); // 2025-02-01
		System.out.println("localDate2.plusDays(1) = " + localDate2.plusDays(1)); // 2025-01-02
		System.out.println("localDate2.plusWeeks(1) = " + localDate2.plusWeeks(1)); // 2025-01-08
		System.out.println("localDate2.minusYears(1) = " + localDate2.minusYears(1)); // 2024-01-01
		System.out.println("localDate2.minusMonths(1) = " + localDate2.minusMonths(1)); // 2024-12-01
		System.out.println("localDate2.minusDays(1) = " + localDate2.minusDays(1)); // 2024-12-31
		System.out.println("localDate2.minusWeeks(1) = " + localDate2.minusWeeks(1)); // 2024-12-25
		
		// LocalDate 두 날짜의 차이
		// Period 클래스를 이용한다.
		// 뒷 날짜에 앞 날짜를 뺀다. (두 번째 매개변수가 빠른날이면 결과값이 음수)
		Period period1 = Period.between(localDate1, localDate2);
		
		System.out.println("period1 = " + period1); // P1Y1M1D 포맷으로 표시 ISO-8601 표준
		System.out.println("period1.getYears() = " + period1.getYears()); // 0
		System.out.println("period1.getMonths() = " + period1.getMonths()); // -4
		System.out.println("period1.getDays() = " + period1.getDays()); // -25
		
		// LocalTime 클래스
		// LocalTime 은 시간을 나타내는 클래스이다.
		LocalTime localTime1 = LocalTime.now();
		
		System.out.println("localTime1 = " + localTime1); // 시간:분:초 로 시간을 표시한다. // 시스템 시간을 따른다.
		System.out.println("localTime1.getHour() = " + localTime1.getHour()); // 시간 리턴
		System.out.println("localTime1.getMinute() = " + localTime1.getMinute()); // 분 리턴
		System.out.println("localTime1.getSecond() = " + localTime1.getSecond()); // 초 리턴
		
		// LocalTime.of() 로 원하는 LocalTime 클래스를 만든다.
		LocalTime localTime2 = LocalTime.of(0, 0, 0);
		
		// LocalTime 클래스의 주요 메소드
		System.out.println("localTime2.plusHours(1) = " + localTime2.plusHours(1)); // 01:00
		System.out.println("localTime2.plusMinutes(1) = " + localTime2.plusMinutes(1)); // 00:01
		System.out.println("localTime2.plusSeconds(1) = " + localTime2.plusSeconds(1)); // 00:00:01
		System.out.println("localTime2.minus(1) = " + localTime2.minusHours(1)); // 23:00
		System.out.println("localTime2.minusMinutes(1) = " + localTime2.minusMinutes(1)); // 23:59
		System.out.println("localTime2.minusSeconds(1) = " + localTime2.minusSeconds(1)); // 23:59:59
		
		
		// LocalTime 의 시간 차이는 Duration 클래스를 이용한다.
		Duration duration2 = Duration.between(localTime1, localTime2);
		
		System.out.println("duration2 = " + duration2); // ISO-8601 시간을 나타내는 포맷 PT-3H-6M-45S
		
		// Duration 에서 시 분 초 나누기
		long time = Math.abs(duration2.getSeconds());
		long hour = time / 3600;
		time = time % 3600;
		long minute = time / 60;
		time = time % 60;
		long second = time;
		
		System.out.println("hour = " + hour); // 시간
		System.out.println("minute = " + minute); // 분
		System.out.println("second = " + second); // 초
		
		// LocalDateTime 클래스
		// LocalDateTime 클래스는 날짜 정보와 시간 정보를 동시에 나타낸다.
		LocalDateTime localDateTime1 = LocalDateTime.now();
		
		System.out.println("localDateTime1 = " + localDateTime1); // 연-월-일T시:분:초 형식
		System.out.println("localDateTime1.getYear() = " + localDateTime1.getYear());
		System.out.println("localDateTime1.getMonth() = " + localDateTime1.getMonth());
		System.out.println("localDateTime1.getMonth().getValue() = " + localDateTime1.getMonth().getValue());
		System.out.println("localDateTime1.getDayOfMonth() = " + localDateTime1.getDayOfMonth());
		System.out.println("localDateTime1.getDayOfWeek() = " + localDateTime1.getDayOfWeek());
		
		// LocalDateTime 클래스의 주요 메소드
		LocalDateTime localDateTime2 = LocalDateTime.of(2025, 01, 01, 01, 01, 01);
		
		System.out.println("localDateTime2.plusYears(1) = " + localDateTime2.plusYears(1)); // 2026-01-01T01:01:01
		System.out.println("localDateTime2.plusMonths(1) = " + localDateTime2.plusMonths(1)); // 2025-02-01T01:01:01
		System.out.println("localDateTime2.plusDays(1) = " + localDateTime2.plusDays(1)); // 2025-01-02T01:01:01
		System.out.println("localDateTime2.plusHours(1) = " + localDateTime2.plusHours(1)); // 2025-01-01T02:01:01
		System.out.println("localDateTime2.plusMinutes(1) = " + localDateTime2.plusMinutes(1)); // 2025-01-01T01:02:01
		System.out.println("localDateTime2.plusSeconds(1) = " + localDateTime2.plusSeconds(1)); // 2025-01-01T01:01:02
		
		System.out.println("localDateTime2.minusYears(1) = " + localDateTime2.minusYears(1)); // 2024-01-01T01:01:01
		System.out.println("localDateTime2.minusMonths(1) = " + localDateTime2.minusMonths(1)); // 2024-12-01T01:01:01
		System.out.println("localDateTime2.minusDays(1) = " + localDateTime2.minusDays(1)); // 2024-12-31T01:01:01
		System.out.println("localDateTime2.minusHours(1) = " + localDateTime2.minusHours(1)); // 2025-01-01T00:01:01
		System.out.println("localDateTime2.minusMinutes(1) = " + localDateTime2.minusMinutes(1)); // 2025-01-01T01:00:01
		System.out.println("localDateTime2.minusSeconds(1) = " + localDateTime2.minusSeconds(1)); // 2025-01-01T01:01
		
		// 두 날짜의 날짜 시간 차이 구하기
		Period   day       = Period.between(localDateTime1.toLocalDate(), localDateTime2.toLocalDate());
		Duration duration3 = Duration.between(localDateTime1.toLocalTime(), localDateTime2.toLocalTime());
		
		System.out.println("day = " + day); // P1Y1M1D 포맷으로 표시 ISO-8601 표준
		System.out.println("duration3 = " + duration3); // PT-3H-6M-45S 포맷으로 표시 ISO-8601 표준
		
		// 시간대를 표현하는 클래스
		// ZoneId 클래스를 이용하면 시간대 정보를 사용할 수 있다.
		ZoneId zoneId1 = ZoneId.of("Europe/Paris"); // region/city
		System.out.println("zoneId1 = " + zoneId1);
		
		ZoneId zoneId2 = ZoneId.of("Asia/Seoul");
		// ZoneId 의 매개변수에 가능한 문자열 확인하는법
		ZoneId.getAvailableZoneIds()
		      .stream()
		      .filter(s -> s.startsWith("Asia")) // Asia 국가들만 필터링
		      .sorted()
		      .forEach(s -> System.out.println("s = " + s));
		
		// 시간대 정보를 갖는 ZonedDateTime 클래스
		// 날짜/시간 정보에 더해서 시간대 정보를 담을 수 있음
		ZonedDateTime zonedDateTime1 = ZonedDateTime.of(LocalDateTime.now(), zoneId2);
		ZonedDateTime zonedDateTime2 = ZonedDateTime.now();
		ZonedDateTime zonedDateTime3 = ZonedDateTime.of(2025, 1, 1, 1, 1, 1, 1, zoneId2);
		
		System.out.println("zonedDateTime1 = " + zonedDateTime1); // YYYY-MM-DD'T'HH:MM:SS.nanoSecond+-UTC[region/city]
		System.out.println("zonedDateTime1.getYear() = " + zonedDateTime1.getYear());
		System.out.println("zonedDateTime1.getMonth() = " + zonedDateTime1.getMonth());
		System.out.println("zonedDateTime1.getMonth().getValue() = " + zonedDateTime1.getMonth().getValue());
		System.out.println("zonedDateTime1.getDayOfMonth() = " + zonedDateTime1.getDayOfMonth());
		System.out.println("zonedDateTime1.getDayOfWeek() = " + zonedDateTime1.getDayOfWeek());
		System.out.println("zonedDateTime1.getHour() = " + zonedDateTime1.getHour());
		System.out.println("zonedDateTime1.getMinute() = " + zonedDateTime1.getMinute());
		System.out.println("zonedDateTime1.getSecond() = " + zonedDateTime1.getSecond());
		System.out.println("zonedDateTime1.getZone() = " + zonedDateTime1.getZone());
		
		// 날짜와 시간의 출력 포맷 설정
		// y = 연, M = 월, d = 일, H = 시, m = 분, s = 초, VV = 시간대
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss [VV]");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy-MM-dd, HH:mm:ss [VV]");
		
		System.out.println("dtf1.format(zonedDateTime1) = " + dtf1.format(zonedDateTime1));
		System.out.println("dtf2.format(zonedDateTime1) = " + dtf2.format(zonedDateTime1));
		
	}
}
