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
package org.openmrs.module.billing.web.legacyweb.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.billing.api.ISequentialReceiptNumberGeneratorService;
import org.openmrs.module.billing.web.CashierWebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Contorller to manage the Sequential Receipt Number Generation
 */
@Controller
@RequestMapping(value = SequentialReceiptNumberGenerator2xController.SEQ_RECEIPT_NUMBER_GENERATOR_URL)
public class SequentialReceiptNumberGenerator2xController extends AbstractSequentialReceiptNumberGenerator {

    public static final String SEQ_RECEIPT_NUMBER_GENERATOR_URL = CashierWebConstants.SEQ_RECEIPT_NUMBER_GENERATOR_PAGE_2X;

    public SequentialReceiptNumberGenerator2xController() {

    }

    @Override
    public ISequentialReceiptNumberGeneratorService getService() {
        return Context.getService(ISequentialReceiptNumberGeneratorService.class);
    }

    @Override
    public String getReceiptNumberGeneratorUrl() {
        return SEQ_RECEIPT_NUMBER_GENERATOR_URL;
    }
}
