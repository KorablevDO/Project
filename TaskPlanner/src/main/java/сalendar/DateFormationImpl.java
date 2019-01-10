package сalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateFormationImpl implements DateFormation {
    private Calendar calendar;

    public CurrentDate getCurrentDate() {
        this.calendar = new GregorianCalendar();
        CurrentDate currentDate = new CurrentDate();
        currentDate.setHour(getHour());
        currentDate.setMinute(getMinute());
        currentDate.setMonth(getMoth());
        currentDate.setDate(getDate());
        currentDate.setWeekday(getWeekday());
        currentDate.setYear(getYear());
        return currentDate;
    }

    private int getHour(){
        return this.calendar.get(Calendar.HOUR_OF_DAY);
    }

    private int getMinute(){
        return this.calendar.get(Calendar.MINUTE);
    }

    private int getMoth(){
        int shift = 1;//в календаре отсчет месяцев начинается с 0;
        return this.calendar.get(Calendar.MONTH) + shift;
    }

    private int getDate(){
        return this.calendar.get(Calendar.DATE);
    }

    private int getWeekday(){
        int shift = 1;// так работае календарь =(;
        return this.calendar.get(Calendar.DAY_OF_WEEK ) - shift;
    }

    private int getYear(){
        return this.calendar.get(Calendar.YEAR);
    }
}
