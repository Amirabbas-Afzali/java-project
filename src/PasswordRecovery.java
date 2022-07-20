public class PasswordRecovery {
    static PasswordRecovery passwordRecovery=new PasswordRecovery();
    public void start(){



        boolean flag1=true,flag2=true,endprogram=false;
        String City,usename="",password="",country,birthdate;

            while (flag1) {
                System.out.println("Enter your Username :");
                usename=Main.scanner.nextLine();
                System.out.println("Enter your City's name :");
                City=Main.scanner.nextLine();
                System.out.println("Enter your Country's name :");
                country=Main.scanner.nextLine();
                System.out.println("Enter your Birthday :");
                birthdate=Main.scanner.nextLine();
                System.out.println(SignIn.signIn.existuser(usename));
                if(SignIn.signIn.existuser(usename).equals("This user exists")){
                    if(checkinfo(SignIn.signIn.searchuser(usename),City,country,birthdate)){
                        System.out.println("Your password is : "+SignIn.signIn.searchuser(usename).PassWord);
                        flag1=false;
                    }
                    else{
                        System.out.println("The information entered is incorrect !");
                    }
                }

            }
    }
    public boolean checkinfo(User user,String city,String country,String birth){
        if(!user.City.equals(city)){return  false;}
        if(!user.Country.equals(country)){return  false;}
        if(!user.Birthdatestr.equals(birth)){return  false;}
return  true;
    }

}
