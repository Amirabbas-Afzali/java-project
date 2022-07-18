import java.util.ArrayList;
import java.util.List;

class BusinessPost extends Post{
    List<String> ViewersUserNames=new ArrayList<>();
    public void LoadViewersUserNames(){}
    public List<String>getViewersUserNames(){return ViewersUserNames;}
     BuisnessType buisnessType;

    public static BusinessPost getBusinessPost(String Code){return new BusinessPost();}
    //BuisnessType buisnessType=BuisnessType.NotSpecial;
    public void setBuisnessType(BuisnessType input){
        buisnessType=input;
    }
    public BuisnessType getBuisnessType(){return buisnessType;}
    public static void BuisnessNewPost(){}
    public void addView(String Username){}
    public String getViewersOrigin(){return "CITY";}
}