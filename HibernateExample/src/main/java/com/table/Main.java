package com.table;
import java.util.HashSet;
import java.util.Set;
 
import org.hibernate.Session;
 
public class Main
{
    public static void main(String[] args) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        //Add projects
        Project pOne = new Project();
        pOne.setName("Java");
         
        Project pTwo = new Project();
        pTwo.setName("C++");
         
        Set<Project> projects = new HashSet<Project>();
        projects.add(pOne);
        projects.add(pTwo);
         
        //Add employees
        Employee eOne = new Employee();
        eOne.setEmail("qq.com");
        eOne.setName("Liu");
        eOne.setAge(18);
        
        Employee eTwo = new Employee();
        eTwo.setEmail("gmail.com");
        eTwo.setName("Tianyi");
        eTwo.setAge(200);    
         
        Set<Employee> employees = new HashSet<Employee>();
        employees.add(eOne);
        employees.add(eTwo);
         
        eOne.setProjects(projects);
        eTwo.setProjects(projects);
 
        session.save(eOne);
        session.save(eTwo);
         
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }
}
