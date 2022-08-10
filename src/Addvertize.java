import java.util.HashMap;
import java.util.List;

public class Addvertize {

    public static HashMap<BuisnessType,Integer>  getAllPostTypeAndPoint(Post post){
        HashMap<BuisnessType,Integer> result=new HashMap<>();
        String input="";
        if (post.Kind){
            input=((BusinessPost)post).description+" "+post.Caption;
        }
        else {
            input=post.Caption;
        }
        result.put(BuisnessType.AD,GivePointToStringByAdvertizeFoodKeys(input));
        result.put(BuisnessType.Cloth,GivePointToStringByClothKeys(input));
        result.put(BuisnessType.Tech,GivePointToStringByTechKeys(input));
        result.put(BuisnessType.Artist,GivePointToStringByArtistKeys(input));
        result.put(BuisnessType.Sport,GivePointToStringBySportKeys(input));
        return result;
    }
    public static BuisnessType getPostType(Post post){
        HashMap<BuisnessType,Integer> Types=getAllPostTypeAndPoint(post);
        int max=0;
        BuisnessType result=null;
        for (BuisnessType i : BuisnessType.values()){
            if (max<Types.get(i)){
                 max=Types.get(i);
                 result=i;
            }
        }
        return result;
    }
    public static void  RemoveNulls(){

    }
    public static Integer GivePointToStringBySportKeys(String input){
        int result=0;
        for ( SportKeys i : SportKeys.values() ){
            if ( input.toLowerCase().contains(i.toString().toLowerCase())) {
                result += 40;
            }
         }
         if (result>input.length()*3)
             result=input.length()*2;
         return result;

     }
    public static Integer GivePointToStringByClothKeys(String input){
        int result=0;
        for (ClothKeys i:ClothKeys.values()){
            if (input.toLowerCase().contains(i.toString().toLowerCase())){
                result+=40;
            }
        }
        if (result>input.length()*3)
            result=input.length()*2;
        return result;
    }
    public static Integer GivePointToStringByArtistKeys(String input){
        int result=0;
        for (ArtistKeys i:ArtistKeys.values()){
            if (input.toLowerCase().contains(i.toString().toLowerCase())){
                result+=40;
            }
        }
        if (result>input.length()*3)
            result=input.length()*2;
        return result;
    }
    public static Integer GivePointToStringByAdvertizeFoodKeys(String input){
        int result=0;
        for (ADvertizeFoodKeys i:ADvertizeFoodKeys.values()){
            if (input.toLowerCase().contains(i.toString().toLowerCase())){
                result+=40;
            }
        }
        if (result>input.length()*3)
            result=input.length()*2;
        return result;
    }
    public static Integer GivePointToStringByTechKeys(String input){
        int result=0;
        for (TechKeys i:TechKeys.values()){
            if (input.toLowerCase().contains(i.toString().toLowerCase())){
                result+=40;
            }
        }
        if (result>input.length()*3)
            result=input.length()*2;
        return result;
    }
     public static Integer followersPoint(User user){
         int input=user.FollowersList.size();
         int i=1,result=1,a=0;
         double delta=0.5,apha=0.1;
         boolean return1=true;
         while (return1){
             if (input>i*10){
                 i*=10;
                 a=i-i/10;
             }
             else {
                 return1=false;
                 a=input-i;
             }
             result+=a*apha;
             apha*=delta;
             delta*=0.7;
         }
         return result;
     }
}
