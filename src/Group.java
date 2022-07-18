public class Group extends DirectMassage{
    int NumberOfUsers;
    String Owener="";
    String bio="";
    public void addMember(){}
    public void removeMember(){}
    public String getOwener(){return Owener;}
    public int getNumberOfUsers() {
        return NumberOfUsers;
    }
    public static Group getGroup(String groupCode){return new Group();}
    public void addGroup(){}

}
