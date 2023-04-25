import java.sql.*;
import java.util.Scanner;
public class Student {
    public void create_table()
    {
        // try
        // {
        //     // Class.forName("com.mysql.cj.jdbc.Driver");
        //     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root", "1234");
        //     System.out.println("Hi");
        //     Scanner scanner=new Scanner(System.in);
        //     String tabname=scanner.nextLine();
        //     Statement st =conn.createStatement();
        //     String query="create table "+tabname;
        //     st.execute(query);
        // }
        // catch(Exception e)
        // {
        //     e.printStackTrace();
        // }
    }
    public void Insert_data(int _prn, String _fname, String _lname, int _age)
    {
        try
        {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root", "1234");
            // System.out.println("Hi");
            // Scanner scanner=new Scanner(System.in);
            String query="insert into student(roll_no , fname ,lname ,Age) values(?,?,?,?)";
            PreparedStatement pst =conn.prepareStatement(query);
            // System.out.println(_prn);
            pst.setInt(1, _prn);
            // scanner.nextLine();
            pst.setString(2, _fname);
            // scanner.nextLine();
            pst.setString(3, _lname);
            pst.setInt(4, _age);
            pst.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public String read_data(int _prn) 
    {
        String ans="";
        try
        {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root", "1234");
            System.out.println(_prn);
            // Scanner scanner=new Scanner(System.in);
            String query="select * from student ";
            Statement st =conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                if(rs.getInt(1)==_prn)
                {
                    ans="Name:"+rs.getString(2)+" "+rs.getString(3)+" Age:"+rs.getInt(4);
                }
            }
            // while(rs.next())
            // {
            //     {
            //         System.out.println("");
            //         System.out.println("name: "+rs.getString(2)+" "+rs.getString(3));
            //         System.out.println("ROLL NO:"+rs.getInt(1));
            //         System.out.println("AGE:"+rs.getInt(4));
            //         System.out.println("");
                    
            //     }
            // }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ans;
    }
    // public void update_RollNo() 
    // {
    //     try
    //     {
    //         // Class.forName("com.mysql.cj.jdbc.Driver");
    //         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root", "1234");
    //         System.out.println("Hi");
    //         Scanner scanner=new Scanner(System.in);
    //         String query="update  student set roll_no = ? where fname=? and lname = ?";
    //         PreparedStatement pst =conn.prepareStatement(query);
    //         pst.setInt(1, scanner.nextInt());
    //         scanner.nextLine();
    //         pst.setString(2, scanner.nextLine());
    //         // scanner.nextLine();
    //         pst.setString(3, scanner.nextLine());
    //         pst.execute();
    //     }
    //     catch(Exception e)
    //     {
    //         e.printStackTrace();
    //     }
    // }
    public void update_fname(int _prn, String _fname) 
    {
        try
        {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root", "1234");
            System.out.println("Hi");
            Scanner scanner=new Scanner(System.in);
            String query="update  student set fname = ? where roll_no= ?";
            PreparedStatement pst =conn.prepareStatement(query);
            pst.setString(1, _fname);
            // scanner.nextLine();
            pst.setInt(2, _prn);
            pst.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void update_lname(int _prn,String _lname) 
    {
        try
        {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root", "1234");
            System.out.println("Hi");
            Scanner scanner=new Scanner(System.in);
            String query="update  student set lname = ? where roll_no= ?";
            PreparedStatement pst =conn.prepareStatement(query);
            pst.setString(1, _lname);
            // scanner.nextLine();
            pst.setInt(2,_prn);
            pst.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void update_age(int _prn,int _age) 
    {
        try
        {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root", "1234");
            System.out.println("Hi");
            Scanner scanner=new Scanner(System.in);
            String query="update  student set age = ? where roll_no= ?";
            PreparedStatement pst =conn.prepareStatement(query);
            pst.setInt(1,_age);
            // scanner.nextLine();
            pst.setInt(2, _prn);
            pst.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void delete_datarow(int _prn) 
    {
        try
        {
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root", "1234");
            String query="delete from student where roll_no=?";
            PreparedStatement stm = conn.prepareStatement(query);
            Scanner scanner=new Scanner(System.in);
            stm.setInt(1,_prn);
            stm.execute();
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }

    }
}