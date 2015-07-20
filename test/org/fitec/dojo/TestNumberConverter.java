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
    public void testOneToRoman() {
        createDecimalToRomanTest(1, "I");
    }

    @Test
    public void testFiveToRoman() {
        createDecimalToRomanTest(5, "V");
    }

    @Test
    public void testTenToRoman() {
        createDecimalToRomanTest(10, "X");
    }

    @Test
    public void testFiftyToRoman() {
        createDecimalToRomanTest(50, "L");
    }

    @Test
    public void testHundredToRoman() {
        createDecimalToRomanTest(100, "C");
    }

    @Test
    public void testFiveHundredToRoman() {
        createDecimalToRomanTest(500, "D");
    }

    @Test
    public void testThousandToRoman() {
        createDecimalToRomanTest(1000, "M");
    }
    
    @Test(expected=RuntimeException.class)
    public void testInvalidDecimalToRoman() {
        createDecimalToRomanTest(-1, null);
    }

    @Test
    public void testIToDecimal() {
        createRomanToDecimalTest("I", 1);
    }

    @Test
    public void testVToDecimal() {
        createRomanToDecimalTest("V", 5);
    }

    @Test
    public void testXToRoman() {
        createRomanToDecimalTest("X", 10);
    }

    @Test
    public void testLToDecimal() {
        createRomanToDecimalTest("L", 50);
    }

    @Test
    public void testCToDecimal() {
        createRomanToDecimalTest("C", 100);
    }

    @Test
    public void testDToDecimal() {
        createRomanToDecimalTest("D", 500);
    }

    @Test
    public void testMToDecimal() {
        createRomanToDecimalTest("M", 1000);
    }
    
    @Test(expected=RuntimeException.class)
    public void testInvalidRomanToDecimal() {
        createRomanToDecimalTest("", null);
    }
    
    @Test
    public void testThreeToRoman() {
        createDecimalToRomanTest(3, "III");
    }
    
    @Test
    public void testIIIToDecimal() {
        createRomanToDecimalTest("III", 3);
    }
    
    @Test
    public void testHundredFiftyToRoman() {
        createDecimalToRomanTest(150, "CL");
    }
    
    @Test
    public void testCLToDecimal() {
        createRomanToDecimalTest("CL", 150);
    }
    
    @Test
    public void testFourToRoman() {
        createDecimalToRomanTest(4, "IV");
    }
    
    @Test
    public void testFortyFourToRoman() {
        createDecimalToRomanTest(44, "XLIV");
    }
    
    @Test
    public void testIVToDecimal() {
        createRomanToDecimalTest("IV", 4);
    }
    
    @Test
    public void testXLIVToDecimal() {
        createRomanToDecimalTest("XLIV", 44);
    }
    
    @Test(expected=RuntimeException.class)
    public void testInvalidRomanWithFourSequence() {
        createRomanToDecimalTest("IIII", null);
    }
    
    private void createDecimalToRomanTest(Integer pDecimal, String pExpectedRoman) {
        String roman = converter.decimalToRoman(pDecimal);
        
        assertEquals(pExpectedRoman, roman);
    }
    
    private void createRomanToDecimalTest(String pRoman, Integer pExpectedDecimal) {
        Integer decimal = converter.romanToDecimal(pRoman);
        
        assertEquals(pExpectedDecimal, decimal);
    }

}
