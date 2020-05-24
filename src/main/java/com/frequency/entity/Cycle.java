package com.frequency.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cycle")
@NamedQuery(name = "Cycle.findByBusinessYearId", query = "SELECT c FROM Cycle c WHERE c.businessYearId.businessYearId =?1")
@NamedQuery(name = "Cycle.findByFrequencyId", query = "SELECT c FROM Cycle c WHERE c.frequencyId.frequencyId =?1")
public class Cycle implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cycle_id")
	private Long cycleId;
	
	
	@JoinColumn(name = "frequency_id", referencedColumnName = "frequency_id")
	@ManyToOne()
	//@Column(name = "frequencyId")
	private Frequency frequencyId;

	@JoinColumn(name = "business_year_id", referencedColumnName = "business_year_id")
	@ManyToOne
	//@Column(name = "businessYearId")
	private Period businessYearId;
	
	@Column(name = "period_name")
	private String periodName;

	@Temporal(TemporalType.DATE)
	@Column(name = "from_date")
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "to_date")
	private Date toDate;

	

	/*@ManyToOne
	@JoinColumn(name = "businessYearId")
	private Period period;*/

	public Cycle() {
		super();
	}

	public Cycle(Long periodId, Period businessYearId, String periodName, Date fromDate, Date toDate,
			Frequency frequencyId) {
		super();
		this.businessYearId = businessYearId;
		this.periodName = periodName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.frequencyId = frequencyId;
	}

	/*	public Period getPeriod() {
			return period;
		}
	
		public void setPeriod(Period period) {
			this.period = period;
		}*/

	public Long getCycleId() {
		return cycleId;
	}

	public Period getBusinessYearId() {
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

	public Frequency getFrequencyId() {
		return frequencyId;
	}

	public void setCycleId(Long cycleId) {
		this.cycleId = cycleId;
	}

	public void setBusinessYearId(Period businessYearId) {
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

	public void setFrequencyId(Frequency frequencyId) {
		this.frequencyId = frequencyId;
	}

}
