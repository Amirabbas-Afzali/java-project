import java.util.ArrayList;
import java.util.List;

class BusinessUser extends User{
    BusinessUser(){}
    //Boolean Kind;
    int ProfileViews;
    List<String> ProfileViewers=new ArrayList<>();
    int AgeSumOfViewers;

    BusinessUser(String username, String passWord, String birthdate, String type){
        this.UserName=username;
        this.PassWord=passWord;
        this.Birthdatestr=birthdate;
        this.setBirthdate();
        this.setBuisnessType(type);
        this.buisnessTypeINT=setBuisnessTypeINT(this.buisnessType);
        this.Kind=true;
        this.ProfileViews=0;
        this.AgeSumOfViewers=0;
        User.UserNamesList.add(this.UserName);
        User.userMap.put(this.UserName,this);
        User.UsersList.add(this);
        User.NumberOfUsers=User.UsersList.size();
    }

    BuisnessType buisnessType;
    int buisnessTypeINT;

    public void setBuisnessType(String type){
        if(type.equals("1")){this.buisnessType=BuisnessType.Tech;}
       else if(type.equals("2")){this.buisnessType=BuisnessType.Cloth;}
        else  if(type.equals("3")){this.buisnessType=BuisnessType.AD;}
        else  if(type.equals("4")){this.buisnessType=BuisnessType.Artist;}
        else  if(type.equals("5")){this.buisnessType=BuisnessType.Sport;}

    }
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

    public int setBuisnessTypeINT(BuisnessType buisnessType1){
        //1.Tech 2.Cloth 3.AD 4.Artist 5.Sport
        if(buisnessType1.equals(BuisnessType.Tech)){return  1;}
        if(buisnessType1.equals(BuisnessType.Cloth)){return 2;}
        if(buisnessType1.equals(BuisnessType.AD)){return 3;}
        if(buisnessType1.equals(BuisnessType.Artist)){return 4;}
        if(buisnessType1.equals(BuisnessType.Sport)){return  5;}
        return 0;
    }

    @Override
    public String toString() {
        return "BusinessUser{" +
                "buisnessType=" + buisnessType +
                ", buisnessTypeINT=" + buisnessTypeINT +
                ", UserName='" + UserName + '\'' +
                ", Name='" + Name + '\'' +
                ", Birthdate=" + Birthdate +
                ", Kind=" + Kind +
                ", isman=" + isman +
                ", married=" + married +
                ", City='" + City + '\'' +
                ", Country='" + Country + '\'' +
                ", Bio='" + Bio + '\'' +
                ", PassWord='" + PassWord + '\'' +
                '}';
    }
}