import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Massage {
    public static int MassageNumber=0;
    public static List<Massage>MassageList=new ArrayList<>();
    public static List<String>MassageCodes= new ArrayList<>();
    String massageString;
    String massageCode="";
    String SenderUserName="";
    Date date;
    public static void addMassage(){}
    public String getMassageCode(){return massageCode;};

    public String getMassageString() {
        return massageString;
    }

    public String getSenderUserName() {
        return SenderUserName;
    }

    @Override
    public String toString() {
        return "Massage{" +
                "massageString='" + massageString + '\'' +
                ", massageCode='" + massageCode + '\'' +
                ", SenderUserName='" + SenderUserName + '\'' +
                ", date=" + date +
                '}';
    }

    public Date getTime() {
        return date;
    }

    public static void setMassageNumber(int massageNumber) {
        MassageNumber = massageNumber;
    }
    public static Massage getMassage(String MassageCode){return new Massage();}

    public void setMassageString(String massageString) {
        this.massageString = massageString;
    }

    public void setTime(Time time) {
        this.date = time;
    }
    public void Update(){}

    public void setSenderUserName(String senderUserName) {
        SenderUserName = senderUserName;
    }
    public void NewMassage(String SenderName){}

}
