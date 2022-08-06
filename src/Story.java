import java.sql.SQLException;
import java.sql.Time;
import java.util.*;

public class Story {
    Story(){}
    public static Integer StoryCodeStatic;

    public String StoryCode="";
    String usernamestory="";
    User user;
    Time date;
    boolean Private;
    boolean IsClose;
    String text;
    List<String> viewersnameList=new ArrayList<>();
    List<String> likersnameList=new ArrayList<>();

    public  Story(String code, String txt, User user1, Time date1, boolean isClose){
        this.StoryCode=code;
        this.text=txt;
        this.user=user1;
        this.usernamestory=user1.UserName;
        this.date=date1;
        this.IsClose=isClose;

        if(user1.Kind){this.Private=false;}
        else {OrdinaryUser ordinaryUser=(OrdinaryUser) user1;
        if(!ordinaryUser.Private){this.Private=false;}
        else {this.Private=true;}
        }

    }


}
