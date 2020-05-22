package com.frequency.constants;

public enum Frequency {

	DAILY(1),
	WEEKLY(7), 
	BIWEEKLY(14), 
	SEMIMONTHLY(15), 
	MONTHLY(31), 
	YEAR(365), 
	LEAPYEAR(366), 
	SUNDAY(7), 
	LEAPFEB(29),
	NONLEAPFEB(28);
	

	int value;
	

	private Frequency(int value) {
		this.value = value;
	}

	

}
