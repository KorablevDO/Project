package сalendar;

public class CurrentDate {
    private int hour;
    private int minute;
    private int date;
    private int weekday;
    private int month;
    private int year;

    public void setHour(int hour){
        this.hour = hour;
    }

    public void setMinute(int minute){
        this.minute = minute;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public int getWeekday() {
        return weekday;
    }

    public int getYear() {
        return year;
    }

    public String toString(){
        return weekday + " " + year + "." + month + "." + date + " " + hour + ":" + minute;
    }
}
