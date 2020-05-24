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
@Table(name = "frequency")

public class Frequency implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "frequency_id")
	private Long frequencyId;

	@Column(name = "frequency_name")
	private String frequencyName;

	/*@ManyToMany(mappedBy = "frequencyList", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private List<Period> periodList = new ArrayList<>();
	*/
	//@ManyToMany(mappedBy = "frequency")
	/*private Period period;*/
	
	@OneToMany(mappedBy ="frequencyId" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cycle> cycleList=new ArrayList<>();
	
	public Frequency() {
		super();
	}

	public Frequency(Long frequencyId, String frequencyName) {
		super();
		this.frequencyId = frequencyId;
		this.frequencyName = frequencyName;
	}
	
	/*	public Period getPeriod() {
			return period;
		}
	
		public void setPeriod(Period period) {
			this.period = period;
		}*/

	public void setFrequencyId(Long frequencyId) {
		this.frequencyId = frequencyId;
	}

	public void setFrequencyName(String frequencyName) {
		this.frequencyName = frequencyName;
	}

	/*public void setPeriod(List<Period> periodList) {
		this.periodList = periodList;
	}*/

	public Long getFrequencyId() {
		return frequencyId;
	}

	public String getFrequencyName() {
		return frequencyName;
	}

	/*	public List<Period> getPeriod() {
			return periodList;
		}
	*/
}
