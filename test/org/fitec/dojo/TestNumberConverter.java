package org.fitec.dojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Bruno Santos
 */
public class TestNumberConverter {
    
    private NumberConverter converter;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        converter = new NumberConverter();
    }

    @Test
    public void testOne() {
        createDecimalToRomanTest(1, "I");
    }

    @Test
    public void testFive() {
        createDecimalToRomanTest(5, "V");
    }

    @Test
    public void testTen() {
        createDecimalToRomanTest(10, "X");
    }

    @Test
    public void testFifty() {
        createDecimalToRomanTest(50, "L");
    }

    @Test
    public void testHundred() {
        createDecimalToRomanTest(100, "C");
    }

    @Test
    public void testFiveHundred() {
        createDecimalToRomanTest(500, "D");
    }

    @Test
    public void testThousand() {
        createDecimalToRomanTest(1000, "M");
    }
    
    @Test(expected=RuntimeException.class)
    public void testInvalidDecimal() {
        createDecimalToRomanTest(-1, null);
    }
    
    @Test(expected=RuntimeException.class)
    public void testEmptyRoman() {
        createRomanToDecimalTest("", null);
    }
    
    @Test
    public void testThree() {
        createDecimalToRomanTest(3, "III");
    }
    
    @Test
    public void testHundredFifty() {
        createDecimalToRomanTest(150, "CL");
    }
    
    @Test
    public void testFour() {
        createDecimalToRomanTest(4, "IV");
    }
    
    @Test
    public void testFortyFour() {
        createDecimalToRomanTest(44, "XLIV");
    }
    
    @Test(expected=RuntimeException.class)
    public void testRomanWithFourSequence() {
        createRomanToDecimalTest("IIII", null);
    }
    
    private void createDecimalToRomanTest(Integer pDecimal, String pExpectedRoman) {
        String roman = converter.decimalToRoman(pDecimal);
        
        assertEquals(pExpectedRoman, roman);
        
        if (pExpectedRoman != null) {
            createRomanToDecimalTest(pExpectedRoman, pDecimal);
        }
    }
    
    private void createRomanToDecimalTest(String pRoman, Integer pExpectedDecimal) {
        Integer decimal = converter.romanToDecimal(pRoman);
        
        assertEquals(pExpectedDecimal, decimal);
    }

}
