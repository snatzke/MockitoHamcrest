package de.codecentric.mockitohamcrest;


import de.codecentric.mockitohamcrest.billing.BillingService;
import de.codecentric.mockitohamcrest.billing.BillingViaPayPal;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.*;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by apotukar on 07.11.2014.
 */
public class CustomerTest {

    public static class UuidLengthMatcher extends TypeSafeMatcher<String> {

        @Override
        public boolean matchesSafely(String uuid) {
            return uuid.length() > 20;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("UUID must be a string with more than 20 chars");
        }
    }

    private static UuidLengthMatcher uuidLengthMatcher;

    @Before
    public void before() {

    }

    @BeforeClass
    public static void beforeClass() {
        uuidLengthMatcher = new UuidLengthMatcher();
    }

    @After
    public void after() {

    }

    @AfterClass
    public static void afterClass() {
        uuidLengthMatcher = null;
    }

    @Test
    public void testDefaultConstructor() {
        Customer customer = new Customer(Mockito.mock(BillingService.class));
        assertNotNull(customer);
        assertNotNull(customer.getUuid());
        assertTrue(customer.getUuid().length() > 20);
        assertThat(customer.getUuid(), uuidLengthMatcher);
        assertThat("Nur im Fehlerfall", "ddddddddarrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr", uuidLengthMatcher);

        System.out.println("BillingViaPayPal real");
        new Customer(new BillingViaPayPal()).payBills();
        System.out.println("BillingViaPayPal mock");
        new Customer(Mockito.mock(BillingViaPayPal.class)).payBills();
        System.out.println("BillingService mock");
        new Customer(Mockito.mock(BillingService.class)).payBills();

        BillingViaPayPal mockedBilligService = new BillingViaPayPal();
        System.out.println(String.format("BillingViaPayPal real with method foo, output: %s", mockedBilligService.foo()));

        mockedBilligService = Mockito.mock(BillingViaPayPal.class);
        System.out.println(String.format("BillingViaPayPal mocked, no stub for method foo, output: %s", mockedBilligService.foo()));

        mockedBilligService = Mockito.mock(BillingViaPayPal.class);
        Mockito.when(mockedBilligService.foo()).thenReturn("Gute Nacht!");
        System.out.println(String.format("BillingViaPayPal stubbed with method foo, output: %s", mockedBilligService.foo()));
    }
}
