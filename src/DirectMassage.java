import java.util.ArrayList;
import java.util.List;
public class DirectMassage {

    boolean isGroup=false;
    public static Integer DirectMassageCodeStatic;
    public static List<String>DirectCodesList=new ArrayList<>();
    List<String>MassageCodes=new ArrayList<>();
    String Code="";
    List<Massage>MassagesList=new ArrayList<>();
    List<String>UserNamesInChat=new ArrayList<>();


    public void LoadMassageCodes(){}
    public void LoadUserNamesInChat(){}
    public List<String>getMassageCodes(){return MassageCodes;}
    public void addMassage(Massage input){}
    public static void addDirect(){}
    public void Update(){}
    public List<String>getUserNamesInChat(){return UserNamesInChat;}
    public  void addUserNameInChat(){}
    public static DirectMassage getDirectMassage(String DirectCode){return new DirectMassage();}
}

