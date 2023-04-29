// Калькулятор времени v2. Необходимо написать программу пересчитывающую секунды в удобный формат времени.
//        Для секунд = 62, ваша программа должна вернуть "1 минуту и 2 секунды"
//        Для секунд = 3662, ваша программа должна вернуть "1 час, 1 минуту и 2 секунды"
//        Правила: Год = 365 дней. Форматы времени разделяются запятыми за исключением последнего.
//        Два последних разделены "и". Форматы времени должны быть отсортированы в порядке убывания:
//        год, месяц, неделя и так далее. Если количество лет, месяцев и прочих = 0, формат следует пропустить.
//        Следующий отрезок не должен содержать в себе времени больше чем минимальная единица времени предыдующего
//        формата - 61 секунда -- это 1 минута и 1 секунда, 60 секунд - 1 минута.

import java.util.Scanner;

public class TimeCalculator {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int SECONDS_IN_HOUR = 60 * SECONDS_IN_MINUTE;
    private static final int SECONDS_IN_DAY = 24 * SECONDS_IN_HOUR;
    private static final int SECONDS_IN_YEAR = 365 * SECONDS_IN_DAY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of seconds: ");
        int seconds = scanner.nextInt();

        if (seconds < 0) {
            System.out.println("Invalid input: time cannot be negative");
            return;
        }

        int years = seconds / SECONDS_IN_YEAR;
        seconds %= SECONDS_IN_YEAR;
        int days = seconds / SECONDS_IN_DAY;
        seconds %= SECONDS_IN_DAY;
        int hours = seconds / SECONDS_IN_HOUR;
        seconds %= SECONDS_IN_HOUR;
        int minutes = seconds / SECONDS_IN_MINUTE;
        seconds %= SECONDS_IN_MINUTE;

        StringBuilder sb = new StringBuilder();
        int numFormats = 0;
        if (years > 0) {
            sb.append(years).append(" year").append(years > 1 ? "s" : "");
            numFormats++;
        }
        if (days > 0 && (numFormats == 0 || (numFormats > 0 && seconds > 0))) {
            if (sb.length() > 0) {
                if (numFormats > 1) {
                    sb.append(" and ");
                } else {
                    sb.append(", ");}
            }
            sb.append(days).append(" day").append(days > 1 ? "s" : "");
            numFormats++;
        }
        if (hours > 0 && (numFormats == 0 || (numFormats > 1 && seconds > 0))) {
            if (sb.length() > 0) {
                if (numFormats > 2) {
                    sb.append(" and ");
                } else {
                    sb.append(", ");
                }
            }
            sb.append(hours).append(" hour").append(hours > 1 ? "s" : "");
            numFormats++;
        }
        if (minutes > 0 && (numFormats == 0 || (numFormats > 2 && seconds > 0))) {
            if (sb.length() > 0) {
                if (numFormats > 3) {
                    sb.append(" and ");
                } else {
                    sb.append(", ");
                }
            }
            sb.append(minutes).append(" minute").append(minutes > 1 ? "s" : "");
            numFormats++;
        }
        if (seconds > 0 && (numFormats == 0 || numFormats > 3)) {
            if (sb.length() > 0) {
                if (numFormats > 4) {
                    sb.append(" and ");} else {
                    sb.append(", ");
                }
            }
            sb.append(seconds).append(" second").append(seconds > 1 ? "s" : "");
        }

        System.out.println(sb.toString());
    }
}