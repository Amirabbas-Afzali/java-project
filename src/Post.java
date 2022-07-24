import java.sql.Time;
import java.util.*;

public class Post {
    static List<String> PostsCodesList1=new ArrayList<>();
    public String PostCode="";
    public static Integer PostCodeStatic;
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

    public void ShowPost(){
        System.out.println("Post Code : "+PostCode+"  ,  "+"Poster : "+PosterName +
                "\n  Date:  "+DateFormat.dateFormat.reportdate(date)+"   ,    Likes : "+LikedList.size()+"   ,  Comments :  " +CommentsCodesList.size()+
                "\n Caption :  " +Caption+"   ,    Repost : "+RepostersList.size());
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


    public String getPostCode(){return PostCode;}
    public void LoadCommentsCodesList(){}
    public List<String>getCommentsCodesList(){return CommentsCodesList;}
    public void LoadPostsCodeLists(){}
    public void LoadRepostersList(){}
    public List<String>getRepostersList(){return RepostersList;}
    public void LoadLikedList(){}
    public List<String>getLikedList(){return LikedList;}
    public int getNumberOfRetwiets() {
        return NumberOfRetwiets;
    }
    public int getNumberOfLikes() {
        return NumberOfLikes;
    }
    public static void NewPost(){}
    public Massage getComments(){return new Massage();}
    public static Post getPost(String PostCode){return new Post();}
    public void addComment(Massage comment){}
    public void Update(){}
    public void CommentHandle(){}
    public void addLike(){}
}
