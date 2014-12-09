package de.codecentric.mockitohamcrest.billing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BillingViaPayPalTest {

    BillingViaPayPal paypalbilling;
    @Before
    public void setUp() throws Exception {
        paypalbilling = new BillingViaPayPal();

    }

    @Test
    public void testExpirationYear() throws Exception {
        assertTrue(paypalbilling.expirationYear()>2100);
    }

}