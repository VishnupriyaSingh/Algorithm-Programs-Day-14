import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Queue;

class WeekDay {
    private String day;
    private String date;

    public WeekDay(String day, String date) {
        this.day = day;
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }
}

class Week {
    private Queue<WeekDay> days;

    public Week() {
        days = new LinkedList<>();
    }

    public void addDay(WeekDay day) {
        days.add(day);
    }

    public Queue<WeekDay> getDays() {
        return days;
    }
}

public class DSQ13 {
    public static void main(String[] args) {
        int month = Calendar.JULY;
        int year = 2005;
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);

        Queue<Week> weeks = new LinkedList<>();
        String[] weekDays = { "S", "M", "T", "W", "Th", "F", "S" };
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;

        Week week = new Week();
        for (int i = 0; i < dayOfWeek; i++) {
            week.addDay(new WeekDay(weekDays[i], ""));
        }

        for (int day = 1; day <= daysInMonth; day++) {
            week.addDay(new WeekDay(weekDays[dayOfWeek], String.valueOf(day)));
            dayOfWeek++;
            if (dayOfWeek > 6) {
                weeks.add(week);
                week = new Week();
                dayOfWeek = 0;
            }
        }

        for (int i = dayOfWeek; i < 7; i++) {
            week.addDay(new WeekDay(weekDays[i], ""));
        }
        weeks.add(week);

        for (Week w : weeks) {
            for (WeekDay wd : w.getDays()) {
                System.out.printf("%-3s ", wd.getDate().isEmpty() ? " " : wd.getDate());
            }
            System.out.println();
        }
    }
}
