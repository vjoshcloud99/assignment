package com.frequency.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cycle")
public class Cycle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cycleId")
	private Long cycleId;
	
	@Column(name = "periodId")
	private Long periodId;
	
	@Column(name = "businessYearId")
	private String businessYearId;
	
	@Column(name = "periodName")
	private String periodName;
	
	@Column(name = "fromDate")
	private Date fromDate;
	
	@Column(name = "toDate")
	private Date toDate;
	
	@Column(name = "frequencyId")
	private Long frequencyId;
	
	@ManyToOne
	@JoinColumn(name = "businessYearId")
	private Period period;
	
	
	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Cycle() {
		super();
	}

	public Cycle(Long periodId, String businessYearId, String periodName, Date fromDate, Date toDate,
			Long frequencyId) {
		super();
		this.periodId = periodId;
		this.businessYearId = businessYearId;
		this.periodName = periodName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.frequencyId = frequencyId;
	}

	public Long getCycleId() {
		return cycleId;
	}

	public Long getPeriodId() {
		return periodId;
	}

	public String getBusinessYearId() {
		return businessYearId;
	}

	public String getPeriodName() {
		return periodName;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public Long getFrequencyId() {
		return frequencyId;
	}

	public void setPeriodId(Long periodId) {
		this.periodId = periodId;
	}

	public void setBusinessYearId(String businessYearId) {
		this.businessYearId = businessYearId;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public void setFrequencyId(Long frequencyId) {
		this.frequencyId = frequencyId;
	}

}
