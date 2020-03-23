package com.table;
import java.util.*;
import javax.persistence.*;


@Entity
@Table(name = "project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
	private long pid;
	
	@Column(name = "proj_name")
	private String name;
	
	@ManyToMany(mappedBy="projects")
    private Set<Employee> employees;

	public long getId() {
		return pid;
	}
	public void setId(long id) {
		this.pid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {

		this.employees = employees;
	}

}
