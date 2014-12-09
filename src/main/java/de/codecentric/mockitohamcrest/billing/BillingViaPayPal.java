package de.codecentric.mockitohamcrest.billing;

/**
 * Created by apotukar on 07.11.2014.
 */
public class BillingViaPayPal implements BillingService {
    @Override
    public void pay() {
        System.out.println("Hey guys, I am the fancy paypal billing service!");
    }

    public String foo() {
        return "Hallo Georg, das wird schon, Du stellst gute Fragen!";
    }
}
