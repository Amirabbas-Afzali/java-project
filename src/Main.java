import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
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
