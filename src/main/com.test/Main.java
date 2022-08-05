import java.sql.*;

public class Main {


    public static void main(String[] args) {
        DbConnect dbConnect = new DbConnect();
        Connection con = dbConnect.connection("testDatabase","postgres","password");
        //dbConnect.createTable(con, "emptable");
        //dbConnect.inert(con, "emptable", "xyz","UK");
        //dbConnect.readData(con,"emptable");
        //dbConnect.updateData(con, "emptable", "abc","iop");
        dbConnect.searchName(con, "emptable","xyz");


    }


}
