import org.testng.Assert;
import org.testng.annotations.Test;
import сalendar.CurrentDate;
import сalendar.DateFormation;
import сalendar.DateFormationImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNG {

    @Test
    private void main() {
        System.out.println("hi");
    }

    @Test
    private void testCalendar() {
        DateFormation calendar = new DateFormationImpl();
        CurrentDate currentDate = calendar.getCurrentDate();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("u yyyy.M.d H:m");
        String testDate = simpleDateFormat.format(date);
        System.out.println(testDate + " - текщая дата, дату которую я получил - " + currentDate);
        Assert.assertEquals(true, testDate.equals(currentDate.toString()));
    }

//    private void testStartTimer(){
//        Timer timer = new CalendarEventTimer();
//        timer.startingTimer();
//
//    }

//    private void testEvent(){
//        Timer timer = new CalendarEventTimer();
//        timer.startingTimer();
//        Event event = new Event();
//        timer.setEvent();
//        timer.deleteEvent();
//        List<Event> list = timer.getListEvent();
//    }
}

/**
 * 1. Запуск таймера, который
 */