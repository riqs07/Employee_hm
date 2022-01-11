import PersistSchema.Employee;
import jakarta.persistence.*;

import java.util.List;

public class EmployeeRepository {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Employee_DB");


    public static void addEmployee(String name,String birthday,int salary,int age){
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Employee e = new Employee();
            e.setName(name);
            e.setBirthday(birthday);
            e.setAge(age);
            e.setSalary(salary);
            em.persist(e);
            em.getTransaction().commit();

        } catch (Exception ex){
            if (em.getTransaction() != null){
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

    }


    public static void getEmployee(int id) {
        EntityManager em = factory.createEntityManager();
        String sql = "SELECT e FROM Employee e WHERE e.id = :empID";

        TypedQuery<Employee> query = em.createQuery(sql,Employee.class);
        query.setParameter("empID",id);
        Employee e = null;

        try {
            e = query.getSingleResult();
            e.showInfo();
        } catch (NoResultException ex){
            ex.printStackTrace();
        } finally {
            em.close();
        }

    }

    public static List<Employee> getAllEmployees() {
        EntityManager em = factory.createEntityManager();
        String sql = "SELECT e FROM Employee e WHERE e.id is not null";

        TypedQuery<Employee> query = em.createQuery(sql,Employee.class);
        List<Employee> employees = null;

        try {
            employees = query.getResultList();


        } catch (NoResultException ex){
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return employees;
    }

    public static void updateEmployeeSalary(int id,int salary) {
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();

            Employee e = em.find(Employee.class,id);

            e.setSalary(salary);
            em.persist(e);
            em.getTransaction().commit();

        } catch (Exception ex){
            if (em.getTransaction() != null){
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

    }

    public static void deleteEmployee(int id) {
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Employee e = em.find(Employee.class,id);

            em.remove(e);
            em.getTransaction().commit();

        } catch (Exception ex){
            if (em.getTransaction() != null){
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

    }


    public static void main(String[] args) {
        addEmployee("Terriq","Sept 16",35000,24);
        updateEmployeeSalary(3,100_000);

        getAllEmployees();


    }

}
