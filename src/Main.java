import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] arg) throws SQLException {
       // SignIn.signIn.start();

      //System.out.println(MassageTableDBC.massageTableDBC.getMassage("1").toString());
        //System.out.println(MassageTableDBC.massageTableDBC.getMassage("1").massageString);
       //OrdinaryUser businessUser=UserTableDBC.userTableDBC.getUser("ali");
       // BusinessUser businessUser1=UserTableDBC.userTableDBC.getUser("amir");
        //System.out.println("OrdUser : "+businessUser1.toString());
     //   UserTableDBC.userTableDBC.EditBusUser("amir");
//        System.out.println("BusUser : "+businessUser.PostCodesList);
     //   User alli=UserTableDBC.userTableDBC.getUser("ali");
   //     alli.UserName="ali2";
    //    UserTableDBC.userTableDBC.setUser(alli);
   //     alli.PassWord="1234";
   //     UserTableDBC.userTableDBC.EditorDeleteUser(UserTableDBC.userTableDBC.getUser(alli.UserName),false);
    System.out.println(DircectMassageTableDBC.dircectMassageTableDBC.getDirectMassage("12"));
    Group group;
    group=DircectMassageTableDBC.dircectMassageTableDBC.getDirectMassage("12");
    group.Code="13";
        //DircectMassageTableDBC.dircectMassageTableDBC.setDirectMassage(group);
        DircectMassageTableDBC.dircectMassageTableDBC.EditorDeleteDirect(group,true);

    }

    public String StringInputGetter(String ShowText, Scanner console){
        System.out.println(ShowText);
        return console.nextLine();
    }
    void LoadStatics(){}
    public void Update(){}
}
