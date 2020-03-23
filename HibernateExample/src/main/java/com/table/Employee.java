package com.table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "employee")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private long eid;
	
	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_email")
	private String email;
	
	@Column(name = "emp_age")
	private int age;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Employee_Project", joinColumns={@JoinColumn(referencedColumnName="emp_id")}
                                        , inverseJoinColumns={@JoinColumn(referencedColumnName="pro_id")}) 
    private Set<Project> projects;
	
	
	public long getId() {
		return eid;
	}
	public void setId(long id) {
		this.eid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {

		this.projects = projects;
	}
}
