package de.codecentric.mockitohamcrest.billing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BillingViaMasterCardTest {

    BillingViaMasterCard mastercardbilling;

    @Before
    public void setUp() throws Exception {
        mastercardbilling = new BillingViaMasterCard();
    }

    @Test
    public void testExpirationYear() throws Exception {
        assertTrue(mastercardbilling.expirationYear()<2020);
        assertTrue(mastercardbilling.expirationYear()>2014);
    }
}