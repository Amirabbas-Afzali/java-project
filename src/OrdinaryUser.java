class OrdinaryUser extends User{
    boolean Private;

    OrdinaryUser(String username,String passWord,String birthdate){
        this.UserName=username;
        this.PassWord=passWord;
        this.Birthdatestr=birthdate;
        this.setBirthdate();
        this.Kind=true;
        User.UserNamesList.add(this.UserName);
        User.UsersList.add(this);
        User.NumberOfUsers=User.UsersList.size();
    }
    public void NewPostOrdinary(){}
}