import java.sql.SQLException;

public class PersonalHomepage {
    static PersonalHomepage personalHomepage=new PersonalHomepage();
    User user;

    public void start(User usertemp) throws SQLException {
        boolean flag=true;
        while (flag){
            String str, strtemp = "Enter a number:\n1.Create new post\n2.show timeline\n3.Complete or Edit personal information\n4.My chats and PVs\n5.My contacts (followers & followings & ...)" +
                    "\n6.Show My posts\n7.back ";
            System.out.println(strtemp);
            str = Main.scanner.nextLine();
            str.trim();
            if (str.equals("1")) {
                CreatenewPost.createnewPost.user=usertemp;
              CreatenewPost.createnewPost.start();
            }
            else if (str.equals("2")) {
                ShowTimeline.showTimeline.user=usertemp;
                ShowTimeline.showTimeline.start();
            }
            else if (str.equals("3")) {
                CompletePersonalInformation.completePersonalInformation.user=usertemp;
                CompletePersonalInformation.completePersonalInformation.start();
            }
            else if (str.equals("4")) {
                MychatsandPVs.mychatsandPVs.user=usertemp;
                MychatsandPVs.mychatsandPVs.start();
            }
            else if (str.equals("5")) {
                Mycontacts.mycontacts.start(usertemp);
            }
            else if (str.equals("6")) {
                ShowPosts.showPosts.user=usertemp;
            ShowPosts.showPosts.start();
            }
            else if (str.equals("7")) {
            flag=false;
            SignIn.signIn.start();
            }
            else {
                System.out.println("Invalid command!");
            }

            }
    }
}
