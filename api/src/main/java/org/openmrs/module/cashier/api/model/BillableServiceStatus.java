package org.openmrs.module.cashier.api.model;

public enum BillableServiceStatus {
	
	ENABLED(1),
	DISABLED(0);
	
	private final int value;
	
	BillableServiceStatus(int value) {
		this.value = value;
	}
}
