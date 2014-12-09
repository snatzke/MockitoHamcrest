package de.codecentric.mockitohamcrest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsNotANumber extends TypeSafeMatcher<Double> {

    @Override
    public boolean matchesSafely(Double number) {
        return number.isNaN();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("not a number");
    }

}
