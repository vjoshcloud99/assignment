package com.frequency.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cycle")
public class Cycle {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "cycleId")
		private Long cycleId;
		
		@ManyToMany
		@JoinColumn(name = "businessYearId",referencedColumnName = "businessYearId")
		@Column(name = "businessYearId")
		private Period businessYearId;
		
		@Column(name = "periodName")
		private String periodName;
		
		@Column(name = "fromDate")
		private Date fromDate;
		
		@Column(name = "toDate")
		private Date toDate;
		
		
		@ManyToMany
		@JoinColumn(name = "frequencyId",referencedColumnName = "frequencyId")
		@Column(name = "frequencyId")
		private Frequency frequencyId;
		
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
	
		public Cycle(Long periodId, Period businessYearId, String periodName, Date fromDate, Date toDate,
				Frequency frequencyId) {
			super();
			this.businessYearId = businessYearId;
			this.periodName = periodName;
			this.fromDate = fromDate;
			this.toDate = toDate;
			this.frequencyId = frequencyId;
		}

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
