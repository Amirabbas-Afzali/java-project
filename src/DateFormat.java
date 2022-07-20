import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    static DateFormat dateFormat=new DateFormat();
    static  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"),formatter2 = new SimpleDateFormat("dd/MM/yyyy");

    public String  reportdate(Date date){
        return  formatter.format(date);
    }
    public String  reportdate2(Date date){
        return  formatter2.format(date);
    }

    public Date StrToDate(String Str){
        try {
            return formatter2.parse(Str);
        }
        catch (Exception e){
            System.out.println("Error Date Format StrToDate");
            return new Date();
        }
    }
}