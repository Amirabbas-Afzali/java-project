import java.util.Scanner;

public class Main {

    public static void main (String[] arg){
        SignIn.signIn.start();

    }

    public String StringInputGetter(String ShowText, Scanner console){
        System.out.println(ShowText);
        return console.nextLine();
    }
    void LoadStatics(){}
    public void Update(){}
}
