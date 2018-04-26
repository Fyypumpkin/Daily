package Java8Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

/**
 * java8中的时间测试
 * @author fyypumpkin on 2018/4/26.
 */

public class TimeTest {
    public static void main(String[] args) {
        // Clock,提供当前时间和日期的访问功能
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());

        Instant instant = clock.instant();
        Date date = Date.from(instant);
        System.out.println(date);

        // TimeZones,时区类
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zoneId1 = ZoneId.of("Asia/Aden");
        ZoneId zoneId2 = ZoneId.of("America/Cuiaba");

        System.out.println(zoneId1.getRules());
        System.out.println(zoneId2.getRules());

        // LocalTime / LocalDate / LocalDateTime本地时间，自己设置，可以计算


    }
}
