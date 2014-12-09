package de.codecentric.mockitohamcrest.billing;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by apotukar on 07.11.2014.
 * Alles zur Rechnungsbegleichung via MasterCard
 */
public class BillingViaMasterCard implements BillingService {

    private int expirationYear;

    public BillingViaMasterCard() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        expirationYear = c.get (Calendar.YEAR)+4;
    }

    @Override
    public void pay() {

    }

    @Override
    public int expirationYear() {
        return expirationYear;
    }
}
