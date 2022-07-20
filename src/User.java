import java.util.*;

import static java.util.Calendar.*;

public class User {
    public static List<String> UserNamesList=new ArrayList<>();
    public static List<User> UsersList=new ArrayList<>();
    static Map<String,User> userMap =new HashMap<>();
    public static int NumberOfUsers=0;
    public List<String>TimeLinePost=new ArrayList<>();
    public String UserName;
    public int age;
    public Date Birthdate;
    public String Birthdatestr;
    public boolean Kind;
    public boolean isman;


    public void setAge(int age) {
        this.age = age;
    }

    public void setIsman(boolean isman) {
        this.isman = isman;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public boolean married;
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
    public  List<Post> posts=new ArrayList<>();


    public void LoadPostCodesList(){}
    public void LoadFollowersList(){}
    public void LoadFollowingList(){}
    public void LoadGroupCodes(){}
    public void LoadDirectMassageCodes(){}
    public void LoadLikedPostCodes(){}
    public void LoadTimeLinePost(){}
    public List<String>getTimeLinePost(){return TimeLinePost;}

   // public void setUserName(String _Username){}

   // public void setPassWord(String _Bio){}

    public void setBio(String _Bio){
this.Bio=_Bio;
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
    public List<User> getFollowing(){
        List<User> result=new ArrayList<>();
        for (String i:getFollowings()){
            result.add(User.UsersList.get(User.UserNamesList.indexOf(i)));
        }
        return result;
    }    public String getFollowers(int index,boolean poll){
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
    public void setBirthdate(){

        //this.Birthdate=;
        try {
            Birthdate=DateFormat.dateFormat.StrToDate(Birthdatestr);
        }
        catch (Exception e){
            System.out.println("Error at User 139");
        }
        calculateAGE();
    }
    public void calculateAGE(){
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
    }
    public static Calendar getCalender(Date date){
          Calendar calendar=Calendar.getInstance(Locale.US);
          calendar.setTime(date);
          return calendar;
    }
}
