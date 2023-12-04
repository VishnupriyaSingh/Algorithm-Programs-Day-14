import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarJava {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java CalendarJava <month> <year>");
            return;
        }
        
        int month = Integer.parseInt(args[0]) - 1; 
        int year = Integer.parseInt(args[1]);

        GregorianCalendar cal = new GregorianCalendar(year, month, 1);

        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        int[][] calendar = new int[6][7];

        int startDay = cal.get(Calendar.DAY_OF_WEEK) - 1; 
        int week = 0;

        for (int day = 1; day <= daysInMonth; day++) {
            calendar[week][startDay] = day;
            startDay++;
            if (startDay > 6) { 
                startDay = 0;
                week++;
            }
        }

        System.out.println("S  M  T  W  Th  F  S");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (calendar[i][j] == 0) {
                    System.out.print("   ");
                } else {
                    System.out.printf("%2d ", calendar[i][j]);
                }
            }
            System.out.println();
        }
    }
}
