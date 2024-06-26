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

package org.openmrs.module.billing.api.impl;

import org.hibernate.criterion.Order;
import org.openmrs.module.billing.api.IPaymentModeService;
import org.openmrs.module.billing.api.base.entity.impl.BaseMetadataDataServiceImpl;
import org.openmrs.module.billing.api.base.entity.security.IMetadataAuthorizationPrivileges;
import org.openmrs.module.billing.api.model.PaymentMode;
import org.openmrs.module.billing.api.security.BasicMetadataAuthorizationPrivileges;
import org.springframework.transaction.annotation.Transactional;

/**
 * Data service implementation class for {@link PaymentMode}s.
 */
@Transactional
public class PaymentModeServiceImpl extends BaseMetadataDataServiceImpl<PaymentMode> implements IPaymentModeService {
	
	@Override
	protected IMetadataAuthorizationPrivileges getPrivileges() {
		return new BasicMetadataAuthorizationPrivileges();
	}
	
	@Override
	protected void validate(PaymentMode entity) {
	}
	
	@Override
	protected Order[] getDefaultSort() {
		return new Order[] { Order.asc("sortOrder"), Order.asc("name") };
	}
}
