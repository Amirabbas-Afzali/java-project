import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class BusinessPost extends Post{
    List<String> ViewersUserNames=new ArrayList<>();
    public List<String>getViewersUserNames(){return ViewersUserNames;}
     BuisnessType buisnessType;
    int buisnessTypeINT;
    String Caption;
    String description;
    BusinessPost(){}
    BusinessPost(String postcode, String text,String describe, BusinessUser user, Date time1) throws SQLException {
        this.userposter=user;
        this.Kind=true;
        this.PostCode=postcode;
        this.Caption=text;
        this.description=describe;
        this.PosterName=user.UserName;
        this.date=time1;
        this.NumberOfLikes=0;
        this.NumberOfRetwiets=0;
        this.buisnessType=user.buisnessType;
         this.buisnessTypeINT=setBuisnessTypeINT(user.buisnessType);
       // Post.PostsList.add(this);
       // Post.postMap.put(postcode,this);
        Post.PostsCodesList1.add(postcode);
       // Post.NumberOfPosts++;
        user.addPostCodeToPosts(postcode);
        //user.PostCodesList.add(postcode);

    }

    public void LoadViewersUserNames(){}
    //public static BusinessPost getBusinessPost(String Code){return new BusinessPost();}
    //BuisnessType buisnessType=BuisnessType.NotSpecial;
    //public void setBuisnessType(String input){}
    //public BuisnessType getBuisnessType(){return buisnessType;}
    public static void BuisnessNewPost(){}
    public void addView(String Username){}
    public String getViewersOrigin(){return "CITY";}

    public int setBuisnessTypeINT(BuisnessType buisnessType1){
        //1.Tech 2.Cloth 3.AD 4.Artist 5.Sport
        if(buisnessType1.equals(BuisnessType.Tech)){return  1;}
        if(buisnessType1.equals(BuisnessType.Cloth)){return 2;}
        if(buisnessType1.equals(BuisnessType.AD)){return 3;}
        if(buisnessType1.equals(BuisnessType.Artist)){return 4;}
        if(buisnessType1.equals(BuisnessType.Sport)){return  5;}
 return 0;
    }

    public void ShowBusPost(){
        System.out.println("Post Code : "+PostCode+"  ,  "+"Poster : "+PosterName+
                "\n  Date:  "+DateFormat.dateFormat.reportdate(date)+"   ,   Likes : "+LikedList.size()+"  " +
                " \n Views : "+ ViewersUserNames.size()+"  ,    " +" Repost : "+RepostersList.size()+"  " +
                "\n  Business Type : "+buisnessType.toString()+
                "\n Caption : "+Caption+"  \n  Description : "+description);

        String input="";
        while (!input.equals("4")){
            System.out.println("");
            System.out.println("1:view comments\n 2:view Likes\n 3:view Reposters \n 4:Back");
            input=Main.scanner.nextLine();
            if (input.equals("1")){

            }
            if (input.equals("2")){

            }
            if (input.equals("3")){

            }
        }
    }
}