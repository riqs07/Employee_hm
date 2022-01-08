package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

///////JDBC IMPLEMENTAION of JDBC.Employee model /////

public class Employee {
    int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    private void printEmployeeName() throws SQLException {
        System.out.println(this.getName());


    };

    private void printEmployeeSalary() throws SQLException{
        System.out.println(this.getName() + "$" + this.getSalary());

    };

    private void printEmployeeData() throws SQLException{
        System.out.println(this.getName()  + "\t" +
                " $" + this.getSalary() + "\t" +
                this.getAge() + "yrs" + "\t" +
                this.getBirthday());
    };



    private String name;
    private String birthday;
    private int salary;
    private int age;

    public Employee(String name, String birthday,int age , int salary){
        this.name = name;
        this.birthday = birthday;
        this.age = age;
        this.salary = salary;
    }
}
