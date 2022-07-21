import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PostTableDBC {
    PostTableDBC() throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {

            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","Amirafzali1382");

        }
        catch (Exception e){
            System.out.println("Error in Connection !");
        }
    }
    Connection connection;
    static PostTableDBC postTableDBC;
    static {
        try {
            postTableDBC = new PostTableDBC();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public <T extends Post>T getPost(String postCode) throws SQLException {
        String quary="SELECT * FROM posttable WHERE PostCode="+"'"+postCode+"'";
        Statement statement=connection.createStatement();
        ResultSet resultSet= statement.executeQuery(quary);
        T result = null;
        while (resultSet.next()){
            boolean isBus=resultSet.getBoolean("Kind");
            if (isBus){
                BusinessPost businessPost=new  BusinessPost();
                businessPost.PostCode=resultSet.getNString("PostCode");
                businessPost.Caption=resultSet.getNString("Caption");
                businessPost.date=resultSet.getDate("date");
                businessPost.Kind=isBus;
                businessPost.RepostersList=getPostCode(resultSet.getNString("RepostersList"));
                businessPost.LikedList=getPostCode(resultSet.getNString("LikedList"));
                businessPost.CommentsCodesList=getPostCode(resultSet.getNString("CommentsCodesList"));
                businessPost.ViewersUserNames=getPostCode(resultSet.getNString("BusViewersUserNames"));
                businessPost.PosterName=resultSet.getNString("PosterUserName");
                businessPost.description=resultSet.getNString("BusDescription");
                businessPost.buisnessType=setBuisnessType(resultSet.getInt("BusTypeINT"));
                result=(T)businessPost;
            }
            else {
                OrdinaryPost businessPost=new  OrdinaryPost();
                businessPost.PostCode=resultSet.getNString("PostCode");
                businessPost.Caption=resultSet.getNString("Caption");
                businessPost.date=resultSet.getDate("date");
                businessPost.Kind=isBus;
                businessPost.RepostersList=getPostCode(resultSet.getNString("RepostersList"));
                businessPost.LikedList=getPostCode(resultSet.getNString("LikedList"));
                businessPost.CommentsCodesList=getPostCode(resultSet.getNString("CommentsCodesList"));
                businessPost.PosterName=resultSet.getNString("PosterUserName");
                businessPost.isprivate=resultSet.getBoolean("Ordisprivate");
                //Add User
                businessPost.userposter=UserTableDBC.userTableDBC.getUser(businessPost.PosterName);
                result=(T)businessPost;
            }
        }
        statement.close();
        return result;
    }

    public<T extends Post> void setPost(T postinput) throws SQLException {
        java.sql.Date date=new java.sql.Date(postinput.date.getTime());
        if (postinput.Kind){
            BusinessPost post=(BusinessPost) postinput;
            PreparedStatement statement= connection.prepareStatement("" +
                    "INSERT INTO posttable (PostCode,Caption,Kind,date," +
                    "RepostersList,LikedList,CommentsCodesList,Ordisprivate," +
                    "BusViewersUserNames,PosterUserName,BusTypeINT," +
                    "BusDescription) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            statement.setNString(1,post.PostCode);
            statement.setNString(2,post.Caption);
            statement.setBoolean(3,post.Kind);
            statement.setDate(4,date);
            statement.setNString(5,generatePostCodeString(post.RepostersList));
            statement.setNString(6,generatePostCodeString(post.LikedList));
            statement.setNString(7,generatePostCodeString(post.CommentsCodesList));
            statement.setBoolean(8,false);
            statement.setNString(9,generatePostCodeString(post.ViewersUserNames));
            statement.setNString(10,post.PosterName);
            statement.setInt(11,post.buisnessTypeINT);
            statement.setString(12,post.description);
            statement.executeUpdate();
            statement.close();
        }
        else {
            OrdinaryPost post=(OrdinaryPost) postinput;
            PreparedStatement statement= connection.prepareStatement("" +
                    "INSERT INTO posttable (PostCode,Caption,Kind,date,RepostersList,LikedList,CommentsCodesList,Ordisprivate,PosterUserName) VALUES (?,?,?,?,?,?,?,?,?)");
            statement.setNString(1,post.PostCode);
            statement.setNString(2,post.Caption);
            statement.setBoolean(3,post.Kind);
            statement.setDate(4,date);
            statement.setNString(5,generatePostCodeString(post.RepostersList));
            statement.setNString(6,generatePostCodeString(post.LikedList));
            statement.setNString(7,generatePostCodeString(post.CommentsCodesList));
            statement.setBoolean(8,false);
            statement.setNString(9,post.PosterName);
            statement.executeUpdate();
            statement.close();
        }

    }

    public <T extends Post> void EditorDeletePost(T postinput,boolean delete)throws SQLException {
            PreparedStatement st = connection.prepareStatement("DELETE FROM posttable WHERE PostCode = '" + postinput.PostCode + "';");
            st.executeUpdate();
            st.close();
            if(!delete){
                setPost(postinput);
            }

    }

    static List<String> getPostCode(String input){
        return Arrays.stream(input.split(",")).toList();
    }

    public BuisnessType setBuisnessType(Integer type){
        BuisnessType result=BuisnessType.AD;
        if(type.equals(1)){result=BuisnessType.Tech;}
        else if(type.equals(2)){result=BuisnessType.Cloth;}
        else  if(type.equals(3)){result=BuisnessType.AD;}
        else  if(type.equals(4)){result=BuisnessType.Artist;}
        else  if(type.equals(5)){result=BuisnessType.Sport;}
        return result;
    }

    public boolean isBusiness(String postCode) throws SQLException {
        boolean result=false;
        String quary="SELECT * FROM posttable WHERE PostCode="+"'"+postCode+"'";
        Statement statement=connection.createStatement();
        ResultSet resultSet= statement.executeQuery(quary);
        while (resultSet.next()){
            result=resultSet.getBoolean("Kind");
        }
        statement.close();
        return result;
    }

    public <T extends Post> HashMap<String,T> getPosts(List<String> postCodes) throws SQLException {
        HashMap<String,T> result=new HashMap<>();
        for (String i:postCodes){
            result.put(i,getPost(i));
        }
        return result;
    }

    public String generatePostCodeString(List<String> input){
        StringBuilder result= new StringBuilder();
        for (String i:input){
            result.append(",").append(i);
        }
        result = new StringBuilder(result.substring(1));
        return result.toString();
    }

}