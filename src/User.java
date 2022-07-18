import java.util.ArrayList;
import java.util.List;

public class User {
    public static List<String> UserNamesList=new ArrayList<>();
    public static List<User> UsersList=new ArrayList<>();
    public static int NumberOfUsers=0;
    public List<String>TimeLinePost=new ArrayList<>();
    public String UserName;
    public int age;
    public boolean Kind;
    public String City;
    public String Country;
    public List<String> PostCodesList=new ArrayList<>();
     List<String>FollowersList=new ArrayList<>();
    List<String>FollowingsList=new ArrayList<>();
    String Bio="";
    String PassWord="";
    List<String> GroupCodes=new ArrayList<>();
    List<String> DirectMassageCodes=new ArrayList<>();
    List<String> LikedPostCodes=new ArrayList<>();
    public void LoadPostCodesList(){}
    public void LoadFollowersList(){}
    public void LoadFollowingList(){}
    public void LoadGroupCodes(){}
    public void LoadDirectMassageCodes(){}
    public void LoadLikedPostCodes(){}
    public void LoadTimeLinePost(){}
    public List<String>getTimeLinePost(){return TimeLinePost;}
    public void setUserName(String _Username){

    }
    public void setPassWord(String _Bio){

    }
    public void setBio(String _Bio){

    }
    public void addPostCode(String _PostCode){

    }
    public void addFollower(String _UserName){

    }
    public void addFollowing(String _UserName){

    }
    public void addLikedPostCode(){

    }
    public void addDirectMassageCode(){

    }
    public void addGroup(){

    }
    public void Update(){}
    public List<String> getFollowings(){
        return FollowingsList;
    }
    public List<String> getFollowers(){
        return FollowersList;
    }
    public List<String>getGroupCodes(){
        return GroupCodes;
    }
    public String getGroup(int index,boolean poll){
        return "temp";
    }
    public List<String>getDirectMassageCodes(){
        return DirectMassageCodes;
    }
    public String getDirectMassage(int index,boolean poll){
        return "temp";
    }
    public List<String>getPostCodesList(){
        return PostCodesList;
    }
    public List<String>getLikedPostCodes(){return LikedPostCodes;}
    String getLikedPost(int index,boolean poll){
        return "temp";
    }
    public String getPost(int index,boolean poll){
        return "temp";
    }
    public String getFollowing(int index,boolean poll){
        return FollowingsList.get(index);
    }
    public String getFollowers(int index,boolean poll){
        return FollowersList.get(index);
    }
    public void NewPost(){}
    public static User getUserPublic(String UserName){
        return new User();
    }
    public static User getUserPrivate(String UserName,String _PassWord){
        return new User();
    }
    public void TimeLine(){}
    public void DMHandle(){}
}
class BusinessUser extends User{
    int ProfileViews=0;
    List<String>ProfileViewers=new ArrayList<>();
    int AgeSumOfViewers=0;
    public void NewPostBuisness(){}
    public void addProfileViews(){

    }
    public void addProfileViewers(String _UserName){

    }
    public void LoadProfileViewers(){

    }

    public String getCountryPollName(){
        return "temp";
    }
    public String getCityPollName(){
        return "temp";
    }
    public int getProfileViews(){
        return -1;
    }
    public int getAverageAge(){
        return -1;
    }
}
class OrdinaryUser extends User{
    boolean Private;
    public void NewPostOrdinary(){}
}