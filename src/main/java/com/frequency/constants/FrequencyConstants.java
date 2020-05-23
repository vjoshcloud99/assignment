package com.frequency.constants;

public enum FrequencyConstants {
	
	DAILY(1L),
	WEEKLY(2L), 
	BIWEEKLY(3L), 
	SEMIMONTHLY(4L), 
	MONTHLY(5L);
	
	/*DAILY(1),
	WEEKLY(7), 
	BIWEEKLY(14), 
	SEMIMONTHLY(15), 
	MONTHLY(31), 
	YEAR(365), 
	LEAPYEAR(366), 
	SUNDAY(7), 
	LEAPFEB(29),
	NONLEAPFEB(28);*/
	

	Long value;
	

	private FrequencyConstants(Long value) {
		this.value = value;
	}
	

   public Long getValue() {
	   return value;
   }

}
