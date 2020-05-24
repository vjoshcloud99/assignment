package com.frequency.entity;

import java.io.Serializable;
import java.util.ArrayList;
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

public class Period implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Logger log = LoggerFactory.getLogger(this.getClass());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "business_year_id")
	private Long businessYearId;

	// @Temporal(TemporalType.DATE)
	@Column(name = "from_date")
	private String fromDate;

	// @Temporal(TemporalType.DATE)
	@Column(name = "to_date")
	private String toDate;

	@Column(name = "year_used_for")
	private String yearUsedFor;

	@OneToMany(mappedBy = "businessYearId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cycle> cycleList = new ArrayList<>();

	/*@ManyToMany
	@JoinTable(name = "cycle", 
			   joinColumns = @JoinColumn(name = "businessYearId", referencedColumnName = "businessYearId"), 
	           inverseJoinColumns = @JoinColumn(name = "frequencyId", referencedColumnName = "frequencyId"))
	private Frequency frequency;*/

	public Period() {
		super();
	}

	public Period(Long businessYearId, String fromDate, String toDate, String yearUsedFor) {
		super();
		this.businessYearId = businessYearId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.yearUsedFor = yearUsedFor;
	}

	public void setBusinessYearId(Long businessYearId) {
		// log.info(" businessYearId >>>>>>>>>>>>>>>>>>>");
		this.businessYearId = businessYearId;
	}

	public Long getBusinessYearId() {
		return businessYearId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public String getYearUsedFor() {
		return yearUsedFor;
	}

	public void setFromDate(String fromDate) {
		// log.info(" fromDate >>>>>>>>>>>>>>>>>>>");
		this.fromDate = fromDate;
	}

	public void setToDate(String toDate) {
		// log.info(" toDate>>>>>>>>>>>>>>>>>>>");
		this.toDate = toDate;
	}

	public void setYearUsedFor(String yearUsedFor) {
		// log.info(" yearUsedFor>>>>>>>>>>>>>>>>>>>");
		this.yearUsedFor = yearUsedFor;
	}

}
