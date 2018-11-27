package VisualCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class VisualCalendar {
    public static void main(String[] args){
        System.out.println("请输入时间(yyyy-MM-dd): ");
        Scanner input = new Scanner(System.in);
        String temp = input.nextLine();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = dateFormat.parse(temp);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);

            int day = calendar.get(Calendar.DATE);
            System.out.println(day);
            int maxDate = calendar.getActualMaximum(Calendar.DATE);

            calendar.set(Calendar.DATE,1);
            System.out.println("日\t一\t二\t三\t四\t五\t六");
            for(int i=1;i<calendar.get(Calendar.DAY_OF_WEEK);i++){
                System.out.print('\t');
            }
            for(int i=1;i<=maxDate;i++) {
                if(i==day){
                    System.out.print('*');
                }
                if(calendar.get(Calendar.DAY_OF_WEEK)==7){
                    System.out.println(i);
                }else{
                    System.out.print(i+"\t");
                }
                calendar.add(Calendar.DATE,1);
            }

        }catch(ParseException e){
            e.printStackTrace();
        }
    }
}
