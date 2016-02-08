package edu.iit.monopoly.constants;

public enum TaxConstants {
	INCOME_TAX(200),LUXURY_TAX(100);
	
	int credits;
	
	private TaxConstants(int credits) {
		this.credits = credits;
	}
}
