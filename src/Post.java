import java.sql.Time;
import java.util.*;

public class Post {

    static List<Post> PostsList=new ArrayList<>();
    static Map<String,Post> postMap =new HashMap<>();
    static List<String> PostsCodesList=new ArrayList<>();
    static int NumberOfPosts=0;
    public String PostCode="";
    public static long PostCodeStatic=0;
    String PosterName="";
    List<String> RepostersList=new ArrayList<>();
    int NumberOfRetwiets;
    int NumberOfLikes;
    Boolean Kind;
    User userposter;
    Date date;
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
