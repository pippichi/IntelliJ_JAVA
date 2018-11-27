package 日期;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class MyDateFormat {
    public static void main(String[] args){
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日hh:mm:ss,每年的第w周，第D天");

        Date d = new Date(12333213231300L);
        String str = df.format(d);
        System.out.println(str);

        String str2 = "1998-02-03 10:02:02";
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
            Date d2 = df2.parse(str2);
            System.out.println(d2);
        }catch(ParseException e){
            e.printStackTrace();
        }
    }
}
