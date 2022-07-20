class OrdinaryUser extends User{
    boolean Private;
   // Boolean Kind=false;
    OrdinaryUser(String username,String passWord,String birthdate, boolean Isprivate){
        this.UserName=username;
        this.PassWord=passWord;
        this.Birthdatestr=birthdate;
        this.setBirthdate();
        this.Kind=false;
        this.Private=Isprivate;
        User.UserNamesList.add(this.UserName);
        User.UsersList.add(this);
        User.userMap.put(this.UserName,this);
        User.NumberOfUsers=User.UsersList.size();
    }
    public void NewPostOrdinary(){}
}