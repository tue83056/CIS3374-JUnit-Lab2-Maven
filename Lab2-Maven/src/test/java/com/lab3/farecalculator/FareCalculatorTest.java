package com.lab3.farecalculator;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;

import com.lab2.transit.FareCalculator;

@RunWith(Parameterized.class)
public class FareCalculatorTest {

	private double expected;
	private int age;
	private String time;
	private boolean isHoliday;
	private static final double DELTA = 1e-15;

	public FareCalculatorTest(double expected, int age, String time,
			boolean isHoliday) {
		this.expected = expected;
		this.age = age;
		this.time = time;
		this.isHoliday = isHoliday;
	}

	@Parameters
	public static Collection<Object[]> testParams() {
		return Arrays.asList(new Object[][] { { 0.0, 5, "6:59", false },
				{ 2.5, 6, "7:00", false }, { 2.5, 64, "9:00", false },
				{ 0.0, 66, "9:00", true }, { 0.0, 65, "9:01", false } });
	}

	@Test
	public void addTest() {
		assertEquals(expected,
				FareCalculator.calculateFare(age, time, isHoliday), DELTA);
	}

}
