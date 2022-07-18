import java.util.Scanner;

public class CreatenewPost {
    static CreatenewPost createnewPost = new CreatenewPost();
    private Scanner scanner = new Scanner(System.in);
    User user;

    public void start() {
        boolean flag = true, flag2 = true;
        while (flag) {
            String temp = "", birthdate, usename, password = "", password2 = "", str, strtemp = "Enter a number:\n1.Create new post\n2.end";
            System.out.println(strtemp);
            str = scanner.nextLine();
            str.trim();
            if (str.equals("1")) {
            }
        }
    }
}
