package de.codecentric.mockitohamcrest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.fest.assertions.Condition;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @see http://www.planetgeek.ch/2012/03/07/create-your-own-matcher/
 * @author apotukar
 */
public class MatchersOverviewTest {

    private static final String STARTING_WITH_CODECENTRIC_REASON = "String should start with Codecentric";

    private Matcher<Date> isSameDay(final Date expected) {

        return new BaseMatcher<Date>() {
            private LocalDateTime getStartOfDay(Date arg) {
                return arg.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atStartOfDay();
            }

            @Override
            public boolean matches(final Object actual) {
                return getStartOfDay(expected).equals(getStartOfDay((Date) actual));
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("getStartOfDay should return ").appendValue(expected);
            }
        };
    }

    private final Condition startingWithCodecentric = new Condition<String>() {
        @Override
        public boolean matches(String value) {
            return value.startsWith("Codecentric");
        }
    };

    @Test
    public void testIsSameDay() {
        Date date = new Date(System.currentTimeMillis() + 60 * 60);
        assertThat(new Date(), isSameDay(date));
        assertThat(new Date(), new BaseMatcher<Date>() {
            @Override
            public boolean matches(Object o) {
                return o instanceof Date;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Argument must be type of Date");
            }
        });
    }

    @Test
    public void testStartsWithCodecentric() {
        String str = "Codecentric is a cool company to work for ;-)";
        org.fest.assertions.Assertions.assertThat(str).as(STARTING_WITH_CODECENTRIC_REASON).is(startingWithCodecentric);
    }

}
