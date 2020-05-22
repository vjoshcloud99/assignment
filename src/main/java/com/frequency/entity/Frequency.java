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
	private String freqencyName;

	public Frequency() {
		super();
	}

	public Frequency(String freqencyName) {
		super();
		this.freqencyName = freqencyName;
	}

	public Long getFrequencyId() {
		return frequencyId;
	}

	public String getFreqencyName() {
		return freqencyName;
	}

	public void setFreqencyName(String freqencyName) {
		this.freqencyName = freqencyName;
	}

}
