package cc.wybxc;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.Objects;

public class MyDate implements Comparable<MyDate> {
    @NotNull LocalDate date;

    /**
     * @param year  年份
     * @param month 月份
     * @param day   日期
     */
    public MyDate(int year, int month, int day) {
        date = LocalDate.of(year, month, day);
    }

    /**
     * @param date 日期字符串，格式为 yyyy-MM-dd
     */
    public MyDate(@NotNull String date) {
        this.date = LocalDate.parse(date);
    }

    public MyDate() {
        this.date = LocalDate.now();
    }

    /**
     * @param date 日期
     */
    public MyDate(@NotNull Temporal date) {
        this.date = LocalDate.from(date);
    }

    /**
     * 获取年份。
     *
     * @return 年份。
     */
    public int getYear() {
        return date.getYear();
    }

    /**
     * 获取月份。
     *
     * @return 月份。
     */
    public int getMonth() {
        return date.getMonthValue();
    }

    /**
     * 获取日期。
     *
     * @return 日期。
     */
    public int getDay() {
        return date.getDayOfMonth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return date.equals(myDate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    /**
     * 增加天数。
     *
     * @param days 天数
     * @return 新的日期
     */
    @NotNull
    public MyDate addDays(int days) {
        return new MyDate(date.plusDays(days));
    }

    /**
     * 增加月数。
     *
     * @param months 月数
     * @return 新的日期
     */
    @NotNull
    public MyDate addMonths(int months) {
        return new MyDate(date.plusMonths(months));
    }

    /**
     * 增加年数。
     *
     * @param years 年数
     * @return 新的日期
     */
    @NotNull
    public MyDate addYears(int years) {
        return new MyDate(date.plusYears(years));
    }

    /**
     * 增加周数。
     *
     * @param weeks 周数
     * @return 新的日期
     */
    @NotNull
    public MyDate addWeeks(int weeks) {
        return new MyDate(date.plusWeeks(weeks));
    }

    /**
     * 增加时间。
     *
     * @param amountToAdd 时间
     * @return 新的日期
     */
    @NotNull
    public MyDate add(@NotNull TemporalAmount amountToAdd) {
        return new MyDate(date.plus(amountToAdd));
    }

    /**
     * 减少天数。
     *
     * @param days 天数
     * @return 新的日期
     */
    @NotNull
    public MyDate minusDays(int days) {
        return new MyDate(date.minusDays(days));
    }

    /**
     * 减少月数。
     *
     * @param months 月数
     * @return 新的日期
     */
    @NotNull
    public MyDate minusMonths(int months) {
        return new MyDate(date.minusMonths(months));
    }

    /**
     * 减少年数。
     *
     * @param years 年数
     * @return 新的日期
     */
    @NotNull
    public MyDate minusYears(int years) {
        return new MyDate(date.minusYears(years));
    }

    /**
     * 减少周数。
     *
     * @param weeks 周数
     * @return 新的日期
     */
    @NotNull
    public MyDate minusWeeks(int weeks) {
        return new MyDate(date.minusWeeks(weeks));
    }

    /**
     * 减少时间。
     *
     * @param amountToSubtract 时间
     * @return 新的日期
     */
    @NotNull
    public MyDate minus(@NotNull TemporalAmount amountToSubtract) {
        return new MyDate(date.minus(amountToSubtract));
    }

    /**
     * 获取星期几。
     *
     * @return 星期几
     */
    public int getDayOfWeek() {
        return date.getDayOfWeek().getValue();
    }

    @Override
    public int compareTo(@NotNull MyDate o) {
        return date.compareTo(o.date);
    }

    @Override
    public String toString() {
        int year = getYear();
        int month = getMonth();
        int day = getDay();
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
