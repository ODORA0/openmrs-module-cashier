/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.billing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.billing.api.ICashierOptionsService;
import org.openmrs.module.billing.api.model.CashierOptions;
import org.openmrs.module.billing.base.BaseModuleContextTest;

public class ICashierOptionsServiceTest extends BaseModuleContextTest {
	
	public static final String OPTIONS_DATASET_VALID = TestConstants.BASE_DATASET_DIR + "CashierOptionsTestValid.xml";
	
	public static final String OPTIONS_DATASET_INVALID = TestConstants.BASE_DATASET_DIR + "CashierOptionsTestInvalid.xml";
	
	private ICashierOptionsService cashierOptionsService;
	
	@Before
	public void before() {
		cashierOptionsService = Context.getService(ICashierOptionsService.class);
	}
	
	/**
	 * @verifies Load options
	 * @see ICashierOptionsService#getOptions()
	 */
	@Test
	public void getOptions_shouldLoadOptions() throws Exception {
		executeDataSet(OPTIONS_DATASET_VALID);
		//		executeDataSet(IDepartmentDataServiceTest.DEPARTMENT_DATASET);
		//		executeDataSet(IItemDataServiceTest.ITEM_DATASET);
		
		CashierOptions options = cashierOptionsService.getOptions();
		Assert.assertNull(options.getRoundingItemUuid());
		Assert.assertEquals(3, options.getDefaultReceiptReportId());
		Assert.assertEquals(CashierOptions.RoundingMode.MID, options.getRoundingMode());
		Assert.assertEquals(0, (int) options.getRoundToNearest());
		Assert.assertTrue(options.isTimesheetRequired());
	}
	
	/**
	 * @verifies Revert to defaults if there are problems loading options
	 * @see ICashierOptionsService#getOptions()
	 */
	@Test
	public void getOptions_shouldRevertToDefaultsIfThereAreProblemsLoadingOptions() throws Exception {
		executeDataSet(OPTIONS_DATASET_INVALID);
		CashierOptions reference = new CashierOptions();
		CashierOptions options = cashierOptionsService.getOptions();
		Assert.assertEquals(reference.getRoundingItemUuid(), options.getRoundingItemUuid());
		Assert.assertEquals(reference.getDefaultReceiptReportId(), options.getDefaultReceiptReportId());
		Assert.assertEquals(reference.getRoundingMode(), options.getRoundingMode());
		Assert.assertEquals(reference.getRoundToNearest(), options.getRoundToNearest());
		Assert.assertEquals(reference.isTimesheetRequired(), options.isTimesheetRequired());
	}
	
}
