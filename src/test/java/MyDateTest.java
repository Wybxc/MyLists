import cc.wybxc.MyDate;
import org.junit.jupiter.api.Test;

import java.time.Period;

public class MyDateTest {
    @Test
    void testConstructor() {
        MyDate date = new MyDate(2023, 4, 15);
        assert date.getYear() == 2023;
        assert date.getMonth() == 4;
        assert date.getDay() == 15;
    }

    @Test
    void testAddDays() {
        MyDate date = new MyDate(2023, 4, 15);
        date = date.addDays(1);
        assert date.getYear() == 2023;
        assert date.getMonth() == 4;
        assert date.getDay() == 16;
        date = date.addDays(30);
        assert date.getYear() == 2023;
        assert date.getMonth() == 5;
        assert date.getDay() == 16;
        date = date.addDays(365);
        assert date.getYear() == 2024;
        assert date.getMonth() == 5;
        assert date.getDay() == 15;
    }

    @Test
    void testAddMonths() {
        MyDate date = new MyDate(2023, 4, 15);
        date = date.addMonths(1);
        assert date.getYear() == 2023;
        assert date.getMonth() == 5;
        assert date.getDay() == 15;
        date = date.addMonths(12);
        assert date.getYear() == 2024;
        assert date.getMonth() == 5;
        assert date.getDay() == 15;
        date = date.addMonths(12);
        assert date.getYear() == 2025;
        assert date.getMonth() == 5;
        assert date.getDay() == 15;
    }

    @Test
    void testAddYears() {
        MyDate date = new MyDate(2023, 4, 15);
        date = date.addYears(1);
        assert date.getYear() == 2024;
        assert date.getMonth() == 4;
        assert date.getDay() == 15;
        date = date.addYears(1);
        assert date.getYear() == 2025;
        assert date.getMonth() == 4;
        assert date.getDay() == 15;
    }

    @Test
    void testAddWeeks() {
        MyDate date = new MyDate(2023, 4, 15);
        date = date.addWeeks(1);
        assert date.getYear() == 2023;
        assert date.getMonth() == 4;
        assert date.getDay() == 22;
        date = date.addWeeks(1);
        assert date.getYear() == 2023;
        assert date.getMonth() == 4;
        assert date.getDay() == 29;
        date = date.addWeeks(1);
        assert date.getYear() == 2023;
        assert date.getMonth() == 5;
        assert date.getDay() == 6;
    }

    @Test
    void testAdd() {
        MyDate date = new MyDate(2023, 4, 15);
        date = date.add(Period.of(1, 1, 1));
        assert date.getYear() == 2024;
        assert date.getMonth() == 5;
        assert date.getDay() == 16;
        date = date.add(Period.of(1, 1, 1));
        assert date.getYear() == 2025;
        assert date.getMonth() == 6;
        assert date.getDay() == 17;
    }

    @Test
    void minusDays() {
        MyDate date = new MyDate(2023, 4, 15);
        date = date.minusDays(1);
        assert date.getYear() == 2023;
        assert date.getMonth() == 4;
        assert date.getDay() == 14;
        date = date.minusDays(30);
        assert date.getYear() == 2023;
        assert date.getMonth() == 3;
        assert date.getDay() == 15;
        date = date.minusDays(365);
        assert date.getYear() == 2022;
        assert date.getMonth() == 3;
        assert date.getDay() == 15;
    }

    @Test
    void minusMonths() {
        MyDate date = new MyDate(2023, 4, 15);
        date = date.minusMonths(1);
        assert date.getYear() == 2023;
        assert date.getMonth() == 3;
        assert date.getDay() == 15;
        date = date.minusMonths(12);
        assert date.getYear() == 2022;
        assert date.getMonth() == 3;
        assert date.getDay() == 15;
        date = date.minusMonths(12);
        assert date.getYear() == 2021;
        assert date.getMonth() == 3;
        assert date.getDay() == 15;
    }

    @Test
    void minusYears() {
        MyDate date = new MyDate(2023, 4, 15);
        date = date.minusYears(1);
        assert date.getYear() == 2022;
        assert date.getMonth() == 4;
        assert date.getDay() == 15;
        date = date.minusYears(1);
        assert date.getYear() == 2021;
        assert date.getMonth() == 4;
        assert date.getDay() == 15;
    }

    @Test
    void minusWeeks() {
        MyDate date = new MyDate(2023, 4, 15);
        date = date.minusWeeks(1);
        assert date.getYear() == 2023;
        assert date.getMonth() == 4;
        assert date.getDay() == 8;
        date = date.minusWeeks(1);
        assert date.getYear() == 2023;
        assert date.getMonth() == 4;
        assert date.getDay() == 1;
        date = date.minusWeeks(1);
        assert date.getYear() == 2023;
        assert date.getMonth() == 3;
        assert date.getDay() == 25;
    }

    @Test
    void minus() {
        MyDate date = new MyDate(2023, 4, 15);
        date = date.minus(Period.of(1, 1, 1));
        assert date.getYear() == 2022;
        assert date.getMonth() == 3;
        assert date.getDay() == 14;
        date = date.minus(Period.of(1, 1, 1));
        assert date.getYear() == 2021;
        assert date.getMonth() == 2;
        assert date.getDay() == 13;
    }

    @Test
    void testGetDayOfWeek() {
        MyDate date = new MyDate(2023, 4, 15);
        assert date.getDayOfWeek() == 6;
        date = new MyDate(2023, 4, 16);
        assert date.getDayOfWeek() == 7;
        date = new MyDate(2023, 4, 17);
        assert date.getDayOfWeek() == 1;
    }

    @Test
    void testCompare() {
        MyDate date = new MyDate(2023, 4, 15);
        MyDate date2 = new MyDate(2023, 4, 15);
        assert date.compareTo(date2) == 0;
        date2 = new MyDate(2023, 4, 16);
        assert date.compareTo(date2) < 0;
        date2 = new MyDate(2023, 4, 14);
        assert date.compareTo(date2) > 0;
        date2 = new MyDate(2023, 3, 15);
        assert date.compareTo(date2) > 0;
        date2 = new MyDate(2023, 5, 15);
        assert date.compareTo(date2) < 0;
        date2 = new MyDate(2022, 4, 15);
        assert date.compareTo(date2) > 0;
        date2 = new MyDate(2024, 4, 15);
        assert date.compareTo(date2) < 0;
    }
}
