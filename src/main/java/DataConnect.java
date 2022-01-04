import java.sql.*;

public class DataConnect {

    private static Connection conn = null;

    public DataConnect(){
        try {
            getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() throws SQLException {
        if (conn == null){
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_hm","root","wolvesCDQ49!");

        }

        return conn;
    }
    ;
    public static void main(String[] args) {
        try {

            Connection db = DataConnect.getInstance();
            Statement s = db.createStatement();

            ResultSet ans = s.executeQuery("select * from employee");

            while (ans.next()){
                System.out.println(ans.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }



}
