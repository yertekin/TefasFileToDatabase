package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversions {

    public static String JavaToMysqlDate(Date javaDate){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(javaDate);
    }

    public static Date TefasDateToJavaDate(String tefasDate) throws ParseException {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.parse(tefasDate);
    }
}
