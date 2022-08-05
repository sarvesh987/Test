import jdk.jfr.consumer.RecordedStackTrace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnect {


    //System.out.println("Hello world");
    public Connection connection(String dbname, String user, String pass){
        Connection con = null;
        try{
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);

            if(con != null)
            {
                System.out.println("Connection Establishment");
            }else {
                System.out.println("Connection failed");
            }



        }catch (Exception e)
        {
            System.out.println(e);
        }
        return con;

    }

    public void createTable(Connection con , String table_Name)
    {
        Statement statement;
        try
        {
        String query = "create table "+table_Name+"(empid SERIAL, name varchar(200), address varchar(200), primary key(empid));";
        statement = con.createStatement();
        statement.executeUpdate(query);
            System.out.println("Table created ");



        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void inert(Connection con, String Table_Name, String name, String address){
        Statement statement;
        try{

            String query = String.format("insert into %s(name,address) values('%s','%s');",Table_Name,name,address);
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted successfully");


        }catch (Exception e)
        {
            System.out.println(e);
        }


    }

    public void readData(Connection con, String tableName)
    {
        Statement statement;
        ResultSet rs = null;

        try{

            String query = String.format("select * from %s",tableName);
            statement= con.createStatement();
            rs= statement.executeQuery(query);
    while(rs.next())
    {
        System.out.print(rs.getString("empid")+" ");
        System.out.print(rs.getString("name")+" ");
        System.out.println(rs.getString("address")+" ");
    }



        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void updateData(Connection con ,String tableName ,String oldName, String newName)
    {
        Statement statement;
        try{

            String query = String.format("update %s set name='%s' where name='%s'", tableName,newName,oldName);
            statement=con.createStatement();
            statement.executeUpdate(query);
            System.out.println("data updated successfully");

        }catch (Exception e )
        {

        }
    }
    public void searchName(Connection con, String tableName, String name)
    {
        Statement statement;
        ResultSet rs=null;

        try {
                String query = String.format("select * from %s where name='%s'",tableName,name);
                statement= con.createStatement();
                rs= statement.executeQuery(query);
                while (rs.next())
                {
                    System.out.print(rs.getString("empid")+" ");
                    System.out.print(rs.getString("name")+" ");
                    System.out.println(rs.getString("address"));


                }

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
