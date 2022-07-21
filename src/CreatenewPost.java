import java.util.Date;
import java.util.Scanner;

public class CreatenewPost {
    static CreatenewPost createnewPost = new CreatenewPost();
    private Scanner scanner = new Scanner(System.in);
    User user;

    public void start() {
        boolean flag = true, flag2 = true;
        String text, description, strtemp = "Enter a number:\n1.Create new post\n2.back",str;
        System.out.println(strtemp);
        str=scanner.nextLine();
        while (flag) {
            if (str.equals("2")) {
                flag = false;
            } else if (str.equals("1")){
                if (user.Kind) {
                    System.out.println("Enter the text of the post :");
                    text = scanner.nextLine();
                    System.out.println("Enter the description of the post :");
                    description = scanner.nextLine();
                    if (text.length() > 0 && description.length() > 0) {
                        BusinessPost businessPost = new BusinessPost(createpostcode(), text, description, (BusinessUser) user, new Date());
                        MAINInformation.mainInformation.posts.add(businessPost);
                        user.posts.add(businessPost);
                        flag=false;
                        System.out.println("Created successful");
                    }
                } else {
                    System.out.println("Enter the text of the post :");
                    text = scanner.nextLine();
                   // System.out.println("Enter a number :\n 1.Create private post\n2.Create public post:");
                    //description = scanner.nextLine();
                //    description.trim();
                    if (text.length() > 0 ) {
                        OrdinaryPost ordinaryPost = new OrdinaryPost(createpostcode(), text, (OrdinaryUser) user, new Date(),((OrdinaryUser) user).Private);
                       MAINInformation.mainInformation.posts.add(ordinaryPost);
                        user.posts.add(ordinaryPost);

                        flag=false;
                        System.out.println("Created successful");
                    }
                }
            }
            else {System.out.println("Invalid command!");}
        }
    }
    public String createpostcode(){
        String result=String.valueOf(Post.PostCodeStatic);
        Post.PostCodeStatic++;
        return result;
    }
    public boolean isprivate(String strr){
        if(strr.equals("1")){return  true;}
        return false;
    }
}
