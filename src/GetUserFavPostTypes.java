import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GetUserFavPostTypes {
    public static HashMap<BuisnessType,Integer> PrefareTypes(User user){
        HashMap<BuisnessType,Integer> result=new HashMap<>(),tempMap;
        result.put(BuisnessType.Tech,0);
        result.put(BuisnessType.Sport,0);
        result.put(BuisnessType.AD,0);
        result.put(BuisnessType.Artist,0);
        result.put(BuisnessType.Cloth,0);
        List <String> Codes=new ArrayList<>();
        for (String i:user.LikedPostCodes){
            try{
                Codes.add(MAINInformation.mainInformation.likeHandleMap.get(i).PostCode);
            }
            catch (Exception e){
                System.out.println("error GetUserFave,Line 20");
                e.printStackTrace();
            }
        }
        for(String i: Codes){
            Post temp=MAINInformation.mainInformation.posts.get(i);
            tempMap=Addvertize.getAllPostTypeAndPoint(temp);
            for (BuisnessType j:result.keySet()){
                if (tempMap.get(j)!=0){
                    result.put(j,result.get(j)+tempMap.get(j)+40);
                }
            }
        }
       return result;
    }
    public static List<Post> getLovedPosts(HashMap<BuisnessType,Integer> input,User user){
        // 0/High
        List<BuisnessType> FirstTypes=new ArrayList<>();
        List<Integer> First=new ArrayList<>(),Second;
        HashMap<Integer,Post> ResultList=new HashMap<>();
        HashMap<BuisnessType,Integer> tempPostValues;
        //List<Post> result=new ArrayList<>();
        //BuisnessType MaxType,MinType;

      //  List<Integer> MyValues=new ArrayList<>();
        List<Post> MyPost = new ArrayList<>();
        for (Post i:MAINInformation.mainInformation.posts.values()){
            if (i.Kind){
                if (!i.UserNameLiked(user.UserName)){
                     MyPost.add(i);
                }
            }
            else {
                if (!((OrdinaryPost)i).isprivate){
                    if (!i.UserNameLiked(user.UserName)){
                        MyPost.add(i);
                    }
                }
            }
        }
        if (MyPost.size()>0)
        for (int i=0;i<MyPost.size();i++){
            int MinInt=10000000;
            tempPostValues=Addvertize.getAllPostTypeAndPoint(MyPost.get(i));
            /*
            for (BuisnessType k:tempPostValues.keySet()){
                FirstTypes.add(k);
                First.add(tempPostValues.get(k));
            }
            */
            for (BuisnessType k:input.keySet()){
                FirstTypes.add(k);
                First.add(input.get(k));
            }
            Second=new ArrayList<>(First);
            Collections.sort(Second);
            //--------------------------
            for (BuisnessType j:BuisnessType.values()){
                if (tempPostValues.get(j)<MinInt){
                    MinInt=tempPostValues.get(j);
                }
            }
            //--------------------------
            int sum=0,Zarib=10;
            for (int j=0;j<5;j++){
                if (MinInt==0){
                    MinInt=1;
                }
              //  System.out.println(Second.get(j));
              //  sum+=(First.get((int)Second.get(j))*Zarib*First.get((int)Second.get(j))/MinInt);
                sum+=(Second.get(j)*input.get(FirstTypes.get(First.indexOf(Second.get(j))))*Zarib*input.get(FirstTypes.get(First.indexOf(Second.get(j))))/MinInt);

                Zarib-=2;
            }
            sum+=Addvertize.followersPoint(MAINInformation.mainInformation.users.get(MyPost.get(i).PosterName));
            sum+=MyPost.get(i).ADMoney;
            sum+=MyPost.get(i).getNumberOfLikes()/2;
            if (MyPost.get(i).Kind){
               sum+= ((BusinessPost)MyPost.get(i)).getViewsNumber()/6;
            }
            if (ResultList.size()<10){
                if (ResultList.containsKey(sum)){
                    sum++;
                    while (ResultList.containsKey(sum)){
                        sum++;
                    }
                    ResultList.put(sum+1,MyPost.get(i));
                }
                else {
                    ResultList.put(sum,MyPost.get(i));
                }
                if (MyPost.get(i).ADMoney>0){
                    MyPost.get(i).setADMoney(MyPost.get(i).ADMoney-1);
                }
            }
            else {
                int min=100000000;
                for (Integer k:ResultList.keySet()){
                    if (min<k){
                        min=k;
                    }
                }
                if (sum>min){
                ResultList.remove(min);
                if (ResultList.containsKey(sum)){
                    sum++;
                    while (ResultList.containsKey(sum)){
                        sum++;
                    }
                    ResultList.put(sum+1,MyPost.get(i));
                }
                else {
                    ResultList.put(sum,MyPost.get(i));
                }
                if (MyPost.get(i).ADMoney>0){
                    MyPost.get(i).setADMoney(MyPost.get(i).ADMoney-1);
                }
                }
            }
        }
        return new ArrayList<>(ResultList.values());
    }
    public static List<Post> getSuggestionPostsForUser(User user){
        return getLovedPosts(PrefareTypes(user),user);
    }

}