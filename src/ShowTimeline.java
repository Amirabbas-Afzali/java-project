import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShowTimeline {
    static ShowTimeline showTimeline=new ShowTimeline();
    User user;
    public void start(){

    }
    public List<String> TimeLinePostCodesList(){
        List<Integer> postcodes=new ArrayList<>();
        List<String> result=new ArrayList<>();
        for (User i:user.getFollowing()){
            for (String j: i.PostCodesList){
                postcodes.add(Integer.parseInt(j));
            }
        }
        Collections.sort(postcodes);
        for (Integer i : postcodes){
            result.add(i.toString());
        }
        return result;
    }
    public List<Post> TimeLinePosts(int n){
        List<String> reference;
        reference=this.TimeLinePostCodesList();
        List<Post> result=new ArrayList<>();
        for (int i=0;i<n;i++){
            result.add(MAINInformation.mainInformation.posts.get(reference.get((reference.size()-i-1))));
        }
        return result;
    }
}