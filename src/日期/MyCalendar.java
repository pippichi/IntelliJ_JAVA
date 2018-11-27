package 日期;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyCalendar {
    public static void main(String[] args){
        Calendar date = new GregorianCalendar();
        date.set(1998,01,03,23,13,02);
        Date date1 = date.getTime();
        System.out.println(date1);


        Calendar d = new GregorianCalendar();
        d.set(Calendar.YEAR,2001);
        d.set(Calendar.MONTH,0);
        d.set(Calendar.DATE,2);
        Date d1 = d.getTime();
        System.out.println(d1);


        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        System.out.println(c.get(Calendar.YEAR));

        c.add(Calendar.YEAR,20);
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        Date date2 = c.getTime();
        String str1 = dateFormat.format(date2);
        System.out.println(str1);
    }
}
