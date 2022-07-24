import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MassageTableDBC {
    MassageTableDBC() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {

            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","Amirafzali1382");

        }
        catch (Exception e){
            System.out.println("Error in Connection !");
        }
    }
    static MassageTableDBC massageTableDBC;
    static {
        try {
            massageTableDBC = new MassageTableDBC();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    Connection connection;

    public Massage getMassage(String MassageCode) throws SQLException {
        String quary="SELECT * FROM massagetable WHERE MassageCode="+"'"+MassageCode+"'";
        Statement statement=connection.createStatement();
        ResultSet resultSet= statement.executeQuery(quary);
        Massage massage=new Massage();
        while (resultSet.next()){
            massage.massageCode=resultSet.getString("MassageCode");
            massage.massageString=resultSet.getString("MassageString");
            massage.SenderUserName=resultSet.getString("SenderUserName");
            massage.date=resultSet.getDate("date");
        }
        statement.close();
        return massage;
    }

    public void setNewMassage(Massage massage) throws SQLException {
        java.sql.Date date=new java.sql.Date(massage.date.getTime());
        PreparedStatement statement= connection.prepareStatement("" +
                "INSERT INTO massagetable (MassageCode,MassageString,SenderUserName,date) VALUES (?,?,?,?)");
        statement.setString(1,massage.massageCode);
        statement.setString(2, massage.massageString);
        statement.setString(3, massage.SenderUserName);
        statement.setDate(4,date);
        statement.executeUpdate();
        statement.close();
    }

    public HashMap<String,Massage> getMassagesMap(List<String> Codes) throws SQLException {
        HashMap<String,Massage> result=new HashMap<>();
        for (String i:Codes){
            result.put(i,getMassage(i));
        }
        return result;
    }

    public void EditOrDeleteMassage(Massage input,boolean delete) throws SQLException {
        PreparedStatement st = connection.prepareStatement("DELETE FROM massagetable WHERE MassageCode = '" + input.massageCode+ "';");
        st.executeUpdate();
        st.close();
        if (!delete){
            setNewMassage(input);
        }
    }

    public List<String> getMassageCodesList() throws SQLException {
        Statement statement=connection.createStatement();
        ResultSet rs = statement.executeQuery("select MassageCode from massagetable");
        List<String> arr=new ArrayList<>();
        while(rs.next()) {
            arr.add(rs.getString("MassageCode"));
        }
        statement.close();
        return arr;
    }

}