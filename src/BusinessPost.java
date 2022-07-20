import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class BusinessPost extends Post{
    Boolean Kind=true;
    List<String> ViewersUserNames=new ArrayList<>();
    public List<String>getViewersUserNames(){return ViewersUserNames;}
     BuisnessType buisnessType;
    String Caption;
    String description;

    BusinessPost(String postcode, String text,String describe, BusinessUser user, Date time1){
        this.PostCode=postcode;
        this.Caption=text;
        this.description=describe;
        this.PosterName=user.UserName;
        this.date=time1;
        this.NumberOfLikes=0;
        this.NumberOfRetwiets=0;
        this.buisnessType=user.buisnessType;
        Post.PostsList.add(this);
        Post.postMap.put(postcode,this);
        Post.PostsCodesList.add(postcode);
        Post.NumberOfPosts++;
    }

    public void LoadViewersUserNames(){}
    //public static BusinessPost getBusinessPost(String Code){return new BusinessPost();}
    //BuisnessType buisnessType=BuisnessType.NotSpecial;
    //public void setBuisnessType(String input){}
    //public BuisnessType getBuisnessType(){return buisnessType;}
    public static void BuisnessNewPost(){}
    public void addView(String Username){}
    public String getViewersOrigin(){return "CITY";}
}