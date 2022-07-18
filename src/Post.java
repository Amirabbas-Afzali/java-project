import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Post {
    boolean Type;
    static List<Post> PostsList=new ArrayList<>();
    static List<String>PostsCodesList=new ArrayList<>();
    static int NumberOfPosts=0;
    public String PostCode="";
    String PosterName="";
    List<String> RepostersList=new ArrayList<>();
    int NumberOfRetwiets=0;
    int NumberOfLikes=0;
    Time time;
    List<String> LikedList=new ArrayList<>();
    String Caption;
    //List<Massage> Comments=new ArrayList<>();
    List<String>CommentsCodesList=new ArrayList<>();
    public String getPostCode(){return PostCode;}
    public void LoadCommentsCodesList(){}
    public List<String>getCommentsCodesList(){return CommentsCodesList;}
    public void LoadPostsCodeLists(){}
    public List<String>getPostsCodesList(){
        return PostsCodesList;
    }
    public void LoadRepostersList(){}
    public List<String>getRepostersList(){return RepostersList;}
    public void LoadLikedList(){}
    public List<String>getLikedList(){return LikedList;}
    public int getNumberOfPosts(){return NumberOfPosts;}
    public int getNumberOfRetwiets() {
        return NumberOfRetwiets;
    }
    public int getNumberOfLikes() {
        return NumberOfLikes;
    }
    public static void NewPost(){}
    public Massage getComments(){return new Massage();}
    public static Post getPost(String PostCode){return new Post();}
    public void addComment(Massage comment){

    }
    public void Update(){}
    public void CommentHandle(){}
    public void addLike(){}
}
class BusinessPost extends Post{
    List<String> ViewersUserNames=new ArrayList<>();
    public void LoadViewersUserNames(){}
    public List<String>getViewersUserNames(){return ViewersUserNames;}
    enum BuisnessType{
        Tech,Cloth,AD,Artist,Sport,NotSpecial
    }
    public static BusinessPost getBusinessPost(String Code){return new BusinessPost();}
    BuisnessType buisnessType=BuisnessType.NotSpecial;
    public void setBuisnessType(BuisnessType input){
        buisnessType=input;
    }
    public BuisnessType getBuisnessType(){return buisnessType;}
    public static void BuisnessNewPost(){}
    public void addView(String Username){}
    public String getViewersOrigin(){return "CITY";}
}