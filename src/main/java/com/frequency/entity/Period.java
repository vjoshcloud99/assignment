package com.frequency.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "period")
public class Period {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "businessYearId")
	private Long businessYearId;


	//@Temporal(TemporalType.DATE)
	@Column(name = "fromDate")
	private Date fromDate;

	//@Temporal(TemporalType.DATE)
	@Column(name = "toDate")
	private Date toDate;

	@Column(name = "yearUsedFor")
	private String yearUsedFor;
	
	


	public Period() {
		super();
	}
	
	public Period( Date fromDate, Date toDate, String yearUsedFor) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.yearUsedFor = yearUsedFor;
	}


	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getYearUsedFor() {
		return yearUsedFor;
	}

	public void setYearUsedFor(String yearUsedFor) {
		this.yearUsedFor = yearUsedFor;
	}

	public Long getBusinessYearId() {
		return businessYearId;
	}

	public void setBusinessYearId(Long businessYearId) {
		this.businessYearId = businessYearId;
	}
	
	

}
