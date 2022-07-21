
import java.util.Date;

public class OrdinaryPost extends Post{
    boolean isprivate;
    OrdinaryPost(){}
    OrdinaryPost(String postcode, String text, OrdinaryUser user, Date time1, boolean Isprivate){
        this.Kind=false;
        this.userposter=user;
        this.PostCode=postcode;
        this.Caption=text;
        this.PosterName=user.UserName;
        this.date=time1;
        this.isprivate=Isprivate;
        this.NumberOfLikes=0;
        this.NumberOfRetwiets=0;
        Post.PostsList.add(this);
        Post.postMap.put(postcode,this);
        Post.PostsCodesList.add(postcode);
        Post.NumberOfPosts++;
        user.PostCodesList.add(postcode);
    }
}
