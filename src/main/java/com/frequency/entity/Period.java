package com.frequency.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "period")
public class Period {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "businessYearId")
	private Long businessYearId;

	@Column(name = "periodId")
	private Long periodId;

	@Column(name = "fromDate")
	private Date fromDate;

	@Column(name = "toDate")
	private Date toDate;

	@Column(name = "yearUsedFor")
	private String yearUsedFor;
	
	@OneToMany(mappedBy = "period", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cycle> cycleList=new ArrayList<>();

	public Period() {
		super();
	}

	public Period(Long periodId, Date fromDate, Date toDate, String yearUsedFor) {
		super();
		this.periodId = periodId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.yearUsedFor = yearUsedFor;
	}

	
	
	public List<Cycle> getCycleList() {
		return cycleList;
	}

	public void setCycleList(List<Cycle> cycleList) {
		this.cycleList = cycleList;
	}

	public Long getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Long periodId) {
		this.periodId = periodId;
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

}
