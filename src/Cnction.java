import java.sql.*;
public class Cnction {
    Connection c;
    Statement s;
    Cnction(){
        try{
            // Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankManagement", "root", "root");
            s=c.createStatement();


        }
        catch (Exception e){
            System.out.println(e);
        }
        
    }
    // public static void main(String[] args) {
        
    // }
             
}
