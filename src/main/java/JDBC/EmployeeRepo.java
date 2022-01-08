package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/// JDBC //

public class EmployeeRepo {

    private static Connection db;

    public EmployeeRepo(Connection db){
        this.db = db;
    }


    public void getAllNames() throws SQLException {


        Statement s = db.createStatement();

        ResultSet ans = s.executeQuery("select * from employee");

        while (ans.next()){
            System.out.println(ans.getString("name"));
        }
    }

    public void createNewEmployee(Employee e) throws SQLException {
        PreparedStatement s = db.prepareStatement("insert into employee (name,birthday,salary,age) values (?,?,?,?)");
        s.setString(1,e.getName());
        s.setString(2,e.getBirthday());
        s.setInt(3,e.getSalary());
        s.setInt(4,e.getAge());

        s.executeUpdate();
        System.out.println("Success, employee added!");
    };

    public void updateEmployee(Employee e,int id) throws SQLException{
        PreparedStatement s = db.prepareStatement( "update employee set name = ?, birthday = ?, salary = ?,age = ? where employee.id = ?");

        s.setString(1,e.getName());
        s.setString(2,e.getBirthday());
        s.setInt(3,e.getSalary());
        s.setInt(4,e.getAge());
        s.setInt(5,id);

        s.executeUpdate();
        System.out.println("Success, employee updated!");
    };




    public List<Employee> getEmployeebyId(int id) throws SQLException {

        PreparedStatement s = db.prepareStatement("select * from employee where employee.id = ?");
        s.setInt(1,id);

        ResultSet ans = s.executeQuery();

        return getEmployeeObjectMap(ans);
    }

    private   List<Employee> getEmployeeObjectMap(ResultSet rows) throws SQLException {

        List<Employee> employees = new ArrayList<>();

        while (rows.next()){


            String name = rows.getString("name");
            String bday = rows.getString("birthday");
            int age = rows.getInt("age");
            int salary = rows.getInt("salary");

            Employee employee = new Employee(name,bday,age,salary);
            employees.add(employee);

        }
        return employees;

    };
    public   List<Employee>  getAllEmployees() throws SQLException {
        PreparedStatement s = db.prepareStatement("select * from employee");

        ResultSet ans = s.executeQuery();

        return getEmployeeObjectMap(ans);


    };




    public void filterBySalary(int salaryMin) throws SQLException {


        List<Employee> employees =  getAllEmployees();


        employees.stream().filter(e -> e.getSalary() > salaryMin).forEach(e -> System.out.println(e.getName()));
    };


    public static void main(String[] args) throws SQLException {

        Connection c = JDBCDataConnect.getInstance();
        EmployeeRepo api = new EmployeeRepo(c);

        api.getAllEmployees();

        Employee Jake = new Employee("Jake","Sep 7",16,9000);

//        api.createNewEmployee(Jake);
//        api.filterBySalary(10000);
    }

}
