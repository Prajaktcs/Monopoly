package edu.iit.monopoly.constants;

public enum CommunityChestCards {
	
	BANK_ERROR(200),SALE(50),Go_TO_JAIL(0),INCOME_TAX_REFUND(20);
	
	int credits;
	
	private CommunityChestCards(int credits) {
		this.credits = credits;
	}
	public int getCredits(){
		return credits;
	}
}
