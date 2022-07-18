import java.util.Scanner;

public class SignIn {
    static SignIn signIn=new SignIn();
    private Scanner scanner = new Scanner(System.in);

    public void start(){
        String usename,password="",str,strtemp="Enter a number:\n1.login\n2.Create new account\n3.end";
        System.out.println(strtemp);
        str= scanner.nextLine();
        str.trim();
        if(str.equals("1")){
        while (true) {
            System.out.println("Enter Username :");
             usename = scanner.nextLine();
            System.out.println(existuser(usename));
            if(existuser(usename).equals("This user exists")) {
                System.out.println("Enter password :");
                password = scanner.nextLine();
                System.out.println(checkpass(searchuser(usename),password));
                if(checkpass(searchuser(usename),password).equals("Welcome")){
                    break;}
            }

        }
            if(checkpass(searchuser(usename),password).equals("Welcome")){PersonalHomepage.personalHomepage.start(searchuser(usename));}
        }
        else if(str.equals("2")){
            CreatAccount.creatAccount.start();
        }
        else if(str.equals("3")){
            System.out.println("by!");
        }
        else {
            System.out.println("Invalid command!");
        }
    }
    public String existuser(String username){
        for(User user: MAINInformation.mainInformation.users){
            if(user.UserName.equals(username)){
                return "This user exists";
            }
        }
       return  "This user not found!";
    }
    public User searchuser(String username){
        for(User user: MAINInformation.mainInformation.users){
            if(user.UserName.equals(username)){
                return user;
            }
        }
        return  null;
    }
    public String checkpass(User user,String password){
            if(user.PassWord.equals(password)){
                return  "Welcome";
            }

       return  "The password is inccorect !";
    }
}
