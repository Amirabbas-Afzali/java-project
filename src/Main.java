import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] arg) throws SQLException {
        //*****************************************
        MAINInformation.mainInformation.UpdateMainInfo();
        SignIn.signIn.start();
   /*  for(User user:   MAINInformation.mainInformation.users.get("ali1").FollowingMap.values()){
          System.out.println(user.UserName);
      }*/

        //*****************************************
     /*   BusinessPost businessPost= (BusinessPost) MAINInformation.mainInformation.posts.get("2");
        MAINInformation.mainInformation.users.get("ali").posts.add(businessPost);
        System.out.println(MAINInformation.mainInformation.users.get("ali").toString());
        System.out.println(MAINInformation.mainInformation.massages.get("1").toString());
        System.out.println(Post.PostCodeStatic);*/

     /*   System.out.println(MAINInformation.mainInformation.users.get("ali").posts.get(0).PosterName);
        System.out.println(MAINInformation.mainInformation.posts.get("2").PosterName);
        MAINInformation.mainInformation.posts.get("2").PosterName="bbb";
        System.out.println(MAINInformation.mainInformation.users.get("ali").posts.get(0).PosterName);
        System.out.println(MAINInformation.mainInformation.posts.get("2").PosterName);
        PostTableDBC.postTableDBC.EditorDeletePost(MAINInformation.mainInformation.posts.get("2"),false);*/


      /*  System.out.println(MAINInformation.mainInformation.users.get("ali1").toString());
        System.out.println(MAINInformation.mainInformation.users.get("ali3").posts.get(0).PosterName);
        System.out.println(MAINInformation.mainInformation.users.get("ali3").posts.get(1).PosterName);
        System.out.println(MAINInformation.mainInformation.users.get("ali3").FollowersList.get(0));
        System.out.println(MAINInformation.mainInformation.users.get("ali3").FollowersList.get(1));
        System.out.println(MAINInformation.mainInformation.users.get("ali3").FollowingMap.get("ali1").Country);
        System.out.println(MAINInformation.mainInformation.users.get("ali3").FollowingMap.get("ali2").Country);*/
      /*  System.out.println(MAINInformation.mainInformation.users.get("ali4").toString());
        System.out.println(UserTableDBC.userTableDBC.StringtoListCode(null));
        BusinessUser businessUser=new BusinessUser();
        businessUser.UserName="ali5";
        businessUser.PassWord="12321";
        businessUser.Birthdate=MAINInformation.mainInformation.users.get("ali4").Birthdate;
        businessUser.Kind=true;
        //UserTableDBC.userTableDBC.setUser(businessUser);
        businessUser.Bio="qqqqqqqqqq";
        UserTableDBC.userTableDBC.EditorDeleteUser(businessUser,false);*/

        //System.out.println(businessUser.PostCodesList.add("56"));
    }

    public String StringInputGetter(String ShowText, Scanner console){
        System.out.println(ShowText);
        return console.nextLine();
    }
    void LoadStatics(){}
    public void Update(){}
}
