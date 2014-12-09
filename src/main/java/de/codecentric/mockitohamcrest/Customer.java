/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.codecentric.mockitohamcrest;

import de.codecentric.mockitohamcrest.billing.BillingViaPayPal;
import de.codecentric.mockitohamcrest.billing.BillingService;

import java.util.UUID;

/**
 * @author apotukar
 */
public class Customer {

    private String uuid;

    private BillingService billingService;

    // most primitive way of DI
    public Customer(BillingService billingService) {
        this(billingService, UUID.randomUUID().toString());
    }

    public Customer(BillingService billingService, String uuid) {
        this.billingService = billingService;
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void payBills() {
        billingService.pay();
    }
}
