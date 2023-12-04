import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

class Stack<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T element) {
        list.addFirst(element);
    }

    public T pop() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T peek() {
        return list.peekFirst();
    }
}

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
    private Stack<WeekDay> days;

    public Week() {
        days = new Stack<>();
    }

    public void addDay(WeekDay day) {
        days.push(day);
    }

    public Stack<WeekDay> getDays() {
        return days;
    }
}

public class DSQ14 {
    public static void main(String[] args) {
        int month = Calendar.JULY;
        int year = 2005;
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);

        Stack<Week> weekStack1 = new Stack<>();
        Stack<Week> weekStack2 = new Stack<>();
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
                weekStack1.push(week);
                week = new Week();
                dayOfWeek = 0;
            }
        }
        for (int i = dayOfWeek; i < 7; i++) {
            week.addDay(new WeekDay(weekDays[i], ""));
        }
        weekStack1.push(week);

        while (!weekStack1.isEmpty()) {
            weekStack2.push(weekStack1.pop());
        }

        while (!weekStack2.isEmpty()) {
            Week currentWeek = weekStack2.pop();
            while (!currentWeek.getDays().isEmpty()) {
                WeekDay wd = currentWeek.getDays().pop();
                System.out.printf("%-3s ", wd.getDate().isEmpty() ? " " : wd.getDate());
            }
            System.out.println();
        }
    }
}
