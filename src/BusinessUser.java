import java.util.ArrayList;
import java.util.List;

class BusinessUser extends User{
    int ProfileViews=0;
    List<String> ProfileViewers=new ArrayList<>();
    int AgeSumOfViewers=0;

    BusinessUser(String username, String passWord, String birthdate, String type){
        this.UserName=username;
        this.PassWord=passWord;
        this.Birthdatestr=birthdate;
        this.setBirthdate();
        this.setBuisnessType(type);
        this.Kind=true;
        User.UserNamesList.add(this.UserName);
        User.UsersList.add(this);
        User.NumberOfUsers=User.UsersList.size();
    }

    BuisnessType buisnessType;
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
}