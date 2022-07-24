import java.sql.SQLException;
import java.util.*;

import static java.util.Calendar.*;

public class User {
    public static List<String> UserNamesList=new ArrayList<>();
  /////////////////////////////////////////
    Map<String,User> FollowerMap =new HashMap<>();
    Map<String,User> FollowingMap =new HashMap<>();
    List<String>FollowersList=new ArrayList<>();
    List<String>FollowingsList=new ArrayList<>();
    ///////////////////////////////////////
    List<String>BlockedList=new ArrayList<>();
    Map<String,User> BlockedMap =new HashMap<>();
    //////////////////////////////////////
    List<String>CloseFriendList=new ArrayList<>();
    Map<String,User> CloseFriendMap =new HashMap<>();
    //////////////////////////////////////
    public List<String>TimeLinePost=new ArrayList<>();
    public List<Post> tempTimeLinePost=new ArrayList<>();
    public  List<Post> posts=new ArrayList<>();
    public String UserName;
    public String Name;
    public int age;
    public Date Birthdate;
    public String Birthdatestr;
    public boolean Kind;
    public boolean isman;
    public boolean married;
    public String City;
    public String Country;
    public List<String> PostCodesList=new ArrayList<>();
    String Bio="";
    String PassWord="";
    List<String> GroupCodes=new ArrayList<>();
    List<String> DirectMassageCodes=new ArrayList<>();
    List<String> LikedPostCodes=new ArrayList<>();

    public void setName(String name) throws SQLException {
           this.Name=name;
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }

    public void setIsman(boolean isman) throws SQLException {
        this.isman = isman;
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }

    public void setMarried(boolean married) throws SQLException {
        this.married = married;
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }

    public void setCity(String city) throws SQLException {
        City = city;
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }

    public void setCountry(String country) throws SQLException {
        Country = country;
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }

    public  void setUnFollow(User user) throws SQLException {
        this.FollowingMap.remove(user.UserName,user);
        this.FollowingsList.remove(user.UserName);
        user.FollowerMap.remove(this.UserName,this);
        user.FollowersList.remove(this.UserName);
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
        UserTableDBC.userTableDBC.EditorDeleteUser(user,false);
    }

    public  void setFollow(User user) throws SQLException {
        this.FollowingMap.put(user.UserName,user);
        this.FollowingsList.add(user.UserName);
        user.FollowerMap.put(this.UserName,this);
        user.FollowersList.add(this.UserName);
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
        UserTableDBC.userTableDBC.EditorDeleteUser(user,false);
    }

    public  void setRemove(User user) throws SQLException {
        this.FollowerMap.remove(user.UserName,user);
        this.FollowersList.remove(user.UserName);
        user.FollowingMap.remove(this.UserName,this);
        user.FollowingsList.remove(this.UserName);
        if(this.CloseFriendMap.containsValue(user)){
            this.CloseFriendMap.remove(user.UserName,user);
            this.CloseFriendList.remove(user.UserName);
        }
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
        UserTableDBC.userTableDBC.EditorDeleteUser(user,false);
    }

    public  void setBlockedUser(User user) throws SQLException {
        this.BlockedMap.put(user.UserName,user);
        this.BlockedList.add(user.UserName);
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }

    public  void setUnBlockedUser(User user) throws SQLException {
        this.BlockedMap.remove(user.UserName,user);
        this.BlockedList.remove(user.UserName);
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }

    public  void setCloseFriendUser(User user) throws SQLException {
        this.CloseFriendMap.put(user.UserName,user);
        this.CloseFriendList.add(user.UserName);
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }

    public  void setRemoveCloseFriendUser(User user) throws SQLException {
        this.CloseFriendMap.remove(user.UserName,user);
        this.CloseFriendList.remove(user.UserName);
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }
    //-----------------------------------------------------
    public void LoadPostCodesList(){}
    public void LoadFollowersList(){}
    public void LoadFollowingList(){}
    public void LoadGroupCodes(){}
    public void LoadDirectMassageCodes(){}
    public void LoadLikedPostCodes(){}
    public void LoadTimeLinePost(){}
    public List<String>getTimeLinePost(){return TimeLinePost;}
    public void addFollower(String _UserName){}
    public void addFollowing(String _UserName){}
    public void addLikedPostCode(){}
    public void addDirectMassageCode(){}
    public void addGroup(){}
    public void Update(){}
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
    public void NewPost(){}
    public static User getUserPublic(String UserName){
        return new User();
    }
    public static User getUserPrivate(String UserName,String _PassWord){
        return new User();
    }
    public void TimeLine(){}
    public void DMHandle(){}
    //----------------------------------------------------------
    public void addPostCode(String _PostCode) throws SQLException {
        this.PostCodesList.add(_PostCode);
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }

    public void addPostToPosts(Post input) throws SQLException {
        posts.add(input);
        addPostCode(input.PostCode);
    }

    public List<String> getFollowings(){
        return FollowingsList;
    }

    public void setBio(String _Bio) throws SQLException {
        this.Bio=_Bio;
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }

    public List<User> getFollowing(){
        List<User> result=new ArrayList<>();
        for (String i:getFollowings()){
            result.add(MAINInformation.mainInformation.users.get(User.UserNamesList.indexOf(i)));
        }
        return result;
    }

    public String getFollowers(int index,boolean poll){
        return FollowersList.get(index);
    }
    public void setBirthdate(){
        try {
            Birthdate=DateFormat.dateFormat.StrToDate(Birthdatestr);
        }
        catch (Exception e){
            System.out.println("Error at User 139");
        }
        calculateAGE();
    }
    public int calculateAGE(){
        Calendar a=getCalender(this.Birthdate),b=getCalender(new Date());
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        try {
            age= diff;
        }
        catch (Exception e){
            System.out.println("Error in User Line 154");
        }
        return this.age;
    }
    public static Calendar getCalender(Date date){
          Calendar calendar=Calendar.getInstance(Locale.US);
          calendar.setTime(date);
          return calendar;
    }
    public void addPostCodeToPosts(String _postCode) throws SQLException {
        this.PostCodesList.add(_postCode);
        UserTableDBC.userTableDBC.EditorDeleteUser(this,false);
    }
}
