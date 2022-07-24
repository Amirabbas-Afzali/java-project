import java.sql.SQLException;
import java.util.*;

public class MAINInformation {
    static MAINInformation mainInformation =new MAINInformation();

    Map<String,User> users=new HashMap<>();
    Map<String,Post> posts=new HashMap<>();
    Map<String,Massage> massages=new HashMap<>();
    Map<String,DirectMassage> directmassages=new HashMap<>();


    public void UpdateMainInfo() throws SQLException {
        fillPosts(PostTableDBC.postTableDBC.getPostCodesList());
        fillusers(UserTableDBC.userTableDBC.getUserNamesList());
        fillMassages(MassageTableDBC.massageTableDBC.getMassageCodesList());
        fillDirectMassages(DircectMassageTableDBC.dircectMassageTableDBC.getDirectMassageCodesList());
        fillsStaticCodes();
        fillFollowers_Followings_Blocked_CloseF();
        processUserPoster();
    }

    public void fillsStaticCodes() throws SQLException {
        Post.PostCodeStatic=StaticTableDBC.staticTableDBC.getCodeNumber("Post");
        DirectMassage.DirectMassageCodeStatic=StaticTableDBC.staticTableDBC.getCodeNumber("DirectMassage");
        Massage.MassageCodeStatic=StaticTableDBC.staticTableDBC.getCodeNumber("Massage");
    }

    public void fillusers(List<String> usernames) throws SQLException {
        for(int i=0;i<usernames.size();i++){
            MAINInformation.mainInformation.users.put(usernames.get(i),UserTableDBC.userTableDBC.getUser(usernames.get(i)));
             processUserPosts(MAINInformation.mainInformation.users.get(usernames.get(i)));
            if(!User.UserNamesList.contains(usernames.get(i))) {User.UserNamesList.add(usernames.get(i));}
        }
    }

    public void fillPosts(List<String> postcodes) throws SQLException {
        for(int i=0;i<postcodes.size();i++){
            MAINInformation.mainInformation.posts.put(postcodes.get(i),PostTableDBC.postTableDBC.getPost(postcodes.get(i)));
        }
    }

    public void fillMassages(List<String> postcodes) throws SQLException {
        for(int i=0;i<postcodes.size();i++){
            MAINInformation.mainInformation.massages.put(postcodes.get(i),MassageTableDBC.massageTableDBC.getMassage(postcodes.get(i)));
        }
    }

    public void fillDirectMassages(List<String> postcodes) throws SQLException {
        for(int i=0;i<postcodes.size();i++){
            MAINInformation.mainInformation.directmassages.put(postcodes.get(i),DircectMassageTableDBC.dircectMassageTableDBC.getDirectMassage(postcodes.get(i)));
        }
    }

    public  void processUserPosts(User user){
        if(null != user.PostCodesList){
        for(String str:user.PostCodesList){
           if(MAINInformation.mainInformation.posts.get(str)!=null){ user.posts.add(MAINInformation.mainInformation.posts.get(str));
        }
        }}
    }

    public void fillFollowers_Followings_Blocked_CloseF(){
        for(User user: MAINInformation.mainInformation.users.values()){
         processUserFollowers(user);
         processUserFollowings(user);
         processUserBlocked(user);
         processUserCloseF(user);
        }
    }

    public  void processUserFollowers(User user){
        if(null != user.FollowersList){
            for(String str:user.FollowersList){
          if(MAINInformation.mainInformation.users.get(str)!=null) { user.FollowerMap.put(str,MAINInformation.mainInformation.users.get(str));}
        }}
    }

    public  void processUserFollowings(User user){
        if(null != user.FollowingsList){
            for(String str:user.FollowingsList){
            if(MAINInformation.mainInformation.users.get(str)!=null) {  user.FollowingMap.put(str,MAINInformation.mainInformation.users.get(str));}
        }}
    }

    public  void processUserBlocked(User user){
        if(null != user.BlockedList){
            for(String str:user.BlockedList){
                if(MAINInformation.mainInformation.users.get(str)!=null) { user.BlockedMap.put(str,MAINInformation.mainInformation.users.get(str));}
            }}
    }

    public  void processUserCloseF(User user){
        if(null != user.CloseFriendList){
            for(String str:user.CloseFriendList){
                if(MAINInformation.mainInformation.users.get(str)!=null) { user.CloseFriendMap.put(str,MAINInformation.mainInformation.users.get(str));}
            }}
    }

    public void processUserPoster(){
        for (Post post:MAINInformation.mainInformation.posts.values()){
            post.userposter=MAINInformation.mainInformation.users.get(post.PosterName);
        }
    }


}
