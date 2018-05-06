package model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import util.BigDecimalDeserializer;

/**
 * Pojo for Project
 * @author maike
 *
 */
@JsonInclude(Include.NON_NULL)
public class Project {
	
	private String name;
	private String customer;
	@JsonDeserialize(using = BigDecimalDeserializer.class)
	private BigDecimal valueOfProject;
	private Date dtBegin;
	private Date dtEnd;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public BigDecimal getValueOfProject() {
		return valueOfProject;
	}
	public void setValueOfProject(BigDecimal valueOfProject) {
		this.valueOfProject = valueOfProject;
	}
	public Date getDtBegin() {
		return dtBegin;
	}
	public void setDtBegin(Date dtBegin) {
		this.dtBegin = dtBegin;
	}
	public Date getDtEnd() {
		return dtEnd;
	}
	public void setDtEnd(Date dtEnd) {
		this.dtEnd = dtEnd;
	}
	
	

}
