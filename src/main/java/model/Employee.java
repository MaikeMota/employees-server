package model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import util.BigDecimalDeserializer;

/**
 * Pojo for Employee
 * @author maike
 *
 */
@JsonInclude(Include.NON_NULL)
public class Employee {

	private String name;
	private String role;
	@JsonDeserialize(using = BigDecimalDeserializer.class)
	private BigDecimal salary;
	private String manager;
	private String gcm;
	private List<Project> projects;
	private List<String> skills;
	private List<String> certification;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getGcm() {
		return gcm;
	}
	public void setGcm(String gcm) {
		this.gcm = gcm;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public List<String> getCertification() {
		return certification;
	}
	public void setCertification(List<String> certification) {
		this.certification = certification;
	}	
	
}
