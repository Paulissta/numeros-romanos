package org.fitec.dojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Santos
 */
public class NumberConverter {

    private class RomanNumber {

        private Integer decimal;
        private String roman;

        public RomanNumber(String pRoman, Integer pDecimal) {
            this.decimal = pDecimal;
            this.roman = pRoman;
        }

    }

    List<RomanNumber> dic = new ArrayList<RomanNumber>();

    public NumberConverter() {
        dic.add(new RomanNumber("M", 1000));
        dic.add(new RomanNumber("D", 500));
        dic.add(new RomanNumber("C", 100));
        dic.add(new RomanNumber("L", 50));
        dic.add(new RomanNumber("X", 10));
        dic.add(new RomanNumber("V", 5));
        dic.add(new RomanNumber("I", 1));
    }

    /**
     * @param pDecimal
     * @return
     */
    public String decimalToRoman(Integer pDecimal) {
        if (pDecimal <= 0) {
            throw new RuntimeException("Invalid decimal!");
        }

        String roman = "";

        while (pDecimal > 0) {
            for (RomanNumber number : dic) {
                if (pDecimal / number.decimal > 0) {
                    roman += number.roman;

                    pDecimal -= number.decimal;

                    break;
                }
            }
        }

        return checkFourCharacterSequence(roman);
    }

    private String checkFourCharacterSequence(String roman) {
        String superiorRoman = null;

        for (RomanNumber singleRoman : dic) {
            if (superiorRoman == null) {
                superiorRoman = singleRoman.roman;
                
                continue;
            }

            int lastIndexOf = roman.lastIndexOf(singleRoman.roman + singleRoman.roman + singleRoman.roman + singleRoman.roman);

            if (lastIndexOf >= 0) {
                roman = roman.substring(0, lastIndexOf) + singleRoman.roman + superiorRoman + roman.substring(lastIndexOf + 4);
            }

            superiorRoman = singleRoman.roman;
        }

        return roman;
    }

    /**
     * @param pRoman
     * @return
     */
    public Integer romanToDecimal(String pRoman) {
        if (pRoman == null || pRoman.isEmpty()) {
            throw new RuntimeException("Invalid roman!");
        }

        Integer decimal = 0;
        Integer lastInteger = null;

        for (Character c : pRoman.toCharArray()) {
            boolean isEqualAnyRoman = false;

            for (RomanNumber number : dic) {
                if (number.roman.equals(c.toString())) {
                    decimal += number.decimal;
                    
                    if (lastInteger != null && lastInteger < number.decimal) {
                        decimal -= lastInteger * 2;
                    }

                    isEqualAnyRoman = true;
                    lastInteger = number.decimal;
                }
            }

            if (!isEqualAnyRoman) {
                throw new RuntimeException("Invalid roman!");
            }
        }

        return decimal;
    }

}
