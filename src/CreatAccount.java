import java.sql.SQLException;

public class CreatAccount {
    static CreatAccount creatAccount=new CreatAccount();

    public void start() throws SQLException {
        boolean flag=true,flag2=true;
        while (flag){
        String description="", temp = "", birthdate, usename="", password = "",usertype="", password2 = "", str, strtemp = "Enter a number:\n1.Create ordinary account\n2.Create business account\n3.end";
        System.out.println(strtemp);
        str = Main.scanner.nextLine();
        str.trim();
        if (str.equals("1")) {
            while (flag2) {
                temp="";
                System.out.println("Enter the username :");
                usename = Main.scanner.nextLine();
                if (!existUsername(usename)) {
                    System.out.println("Enter the password :");
                    password = Main.scanner.nextLine();
                     if(passtextisnormal(password)){
                    System.out.println("Re-enter the password :");
                    password2 = Main.scanner.nextLine();
                    if (password.equals(password2)) {
                        System.out.println("Enter the birthdate (dd/mm/yyyy) :");
                        birthdate = Main.scanner.nextLine();
                        if (birthdateformisnormal(birthdate)) {
                            System.out.println("Enter a number :\n1.Create private account\n2.Create public account");
                            description = Main.scanner.nextLine();
                            description.trim();
                            OrdinaryUser ordinaryUser=new OrdinaryUser(usename,password,birthdate,isprivate(description));
                            UserTableDBC.userTableDBC.setUser(ordinaryUser);
                            MAINInformation.mainInformation.users.put(usename,ordinaryUser);
                            temp = "a";
                            flag2=false;
                        }
                    } else {
                        System.out.println("Re-enter the password correctly !");
                    }}
                    else{
                        System.out.println("Your password must be 8 characters including upper and lower case letters and numbers !");
                    }
                } else {
                    System.out.println("This username was taken !");
                }
            }
              if(temp.equals("a")){
                  PersonalHomepage.personalHomepage.user=searchuser(usename);
                  PersonalHomepage.personalHomepage.start(searchuser(usename));}
        }
        else if (str.equals("2")) {
            while (flag2) {
                temp="";
                System.out.println("Enter the username :");
                usename = Main.scanner.nextLine();
                if (!existUsername(usename)) {
                    System.out.println("Enter the password :");
                    password = Main.scanner.nextLine();
                  if(passtextisnormal(password)){
                    System.out.println("Re-enter the password :");
                    password2 = Main.scanner.nextLine();
                    if (password.equals(password2)) {
                        System.out.println("Enter the birthdate (dd/mm/yyyy) :");
                        birthdate = Main.scanner.nextLine();
                        if (birthdateformisnormal(birthdate)) {
                            System.out.println("Select your business account type :\n1.Tech\n2.Cloth\n3.AD\n4.Artist\n5.Sport");
                            usertype= Main.scanner.nextLine();
                            BusinessUser businessUser=new BusinessUser(usename,password,birthdate,usertype);
                            UserTableDBC.userTableDBC.setUser(businessUser);
                            MAINInformation.mainInformation.users.put(usename,businessUser);
                            temp = "a";
                            flag2=false;
                        }
                    }
                    else {
                        System.out.println("Re-enter the password correctly !");
                    }
                      }
                else{
                      System.out.println("Your password must be 8 characters including upper and lower case letters and numbers !");
                }
                }
            else {
                    System.out.println("This username was taken !");
                }
            }
            if(temp.equals("a")){
                PersonalHomepage.personalHomepage.user=searchuser(usename);
                PersonalHomepage.personalHomepage.start(searchuser(usename));}
        }
        else if (str.equals("3")) {
            System.out.println("bye!");
            flag=false;
        } else {
            System.out.println("Invalid command!");
        }
    }
    }
public boolean existUsername(String username){
    for(User user: MAINInformation.mainInformation.users.values()){
        if(user.UserName.equals(username)){
            return true;
        }
    }
    return false;
}
public boolean birthdateformisnormal(String birthdate){
        if(birthdate.length()!=10){return  false;}
        if(birthdate.charAt(2)!='/'){return false;}
        if(birthdate.charAt(5)!='/'){return false;}
return  true;
}
    public User searchuser(String username){
        for(User user: MAINInformation.mainInformation.users.values()){
            if(user.UserName.equals(username)){
                return user;
            }
        }
        return  null;
    }

    public boolean passtextisnormal(String password){
        if(password.length()!=8){return false;}
        boolean big=false,small=false,numb=false;
        for(int i=0;i<8;i++){
            if((int) password.charAt(i)>96&&(int) password.charAt(i)<123){small = true;}
            if((int) password.charAt(i)>47&&(int) password.charAt(i)<58){numb = true;}
            if((int) password.charAt(i)>64&&(int) password.charAt(i)<91){big = true;}
        }
        if(small&&big&&numb){return  true;}
        return false;
    }
  public boolean isprivate(String strr){
      if(strr.equals("1")){return  true;}
      return false;
  }
}
