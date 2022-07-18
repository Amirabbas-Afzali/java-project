import java.util.Scanner;

public class PersonalHomepage {
    static PersonalHomepage personalHomepage=new PersonalHomepage();
    private Scanner scanner = new Scanner(System.in);
    User user;

    public void start(User usertemp){
        boolean flag=true;
        while (flag){
            String str, strtemp = "Enter a number:\n1.Create new post\n2.show timeline\n3.Complete personal information\n4.My chats and PVs\n5.My contacts (followers & followings & ...)" +
                    "\n6.Show posts\n7.end ";
            System.out.println(strtemp);
            str = scanner.nextLine();
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
            Mycontacts.mycontacts.user=usertemp;
                Mycontacts.mycontacts.start();
            }
            else if (str.equals("6")) {
                ShowPosts.showPosts.user=usertemp;
            ShowPosts.showPosts.start();
            }
            else if (str.equals("6")) {
            flag=false;
            }
            else {
                System.out.println("Invalid command!");
            }

            }

    }
}
