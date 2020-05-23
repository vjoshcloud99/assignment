package com.frequency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "frequency")
public class Frequency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "frequencyId")
	private Long frequencyId;

	@Column(name = "freqencyName")
	private String frequencyName;

	/*@ManyToMany(mappedBy = "frequencyList", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private List<Period> periodList = new ArrayList<>();
	*/
	public Frequency() {
		super();
	}

	public Frequency(Long frequencyId, String frequencyName) {
		super();
		this.frequencyId = frequencyId;
		this.frequencyName = frequencyName;
	}

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
