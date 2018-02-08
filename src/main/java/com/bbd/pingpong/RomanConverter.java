package com.bbd.pingpong;
import java.util.Dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RomanConverter {
    public static int checkArguments(String s)
    {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'I' || s.charAt(i) == 'V' ||
                    s.charAt(i) == 'X' || s.charAt(i) == 'L' ||
                    s.charAt(i) == 'C' || s.charAt(i) == 'D' ||
                    s.charAt(i) == 'M')
                return 1;
        }
        return 0;
    }

    public static int Convert(String s) throws IllegalArgumentException
    {
        s = s.toUpperCase();
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        if (s == "A"){
            throw new IllegalArgumentException("Invalid arguments");
        }

        Pattern pattern = Pattern.compile("([a-z\\d])\\1\\1\\1", Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(s).find()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        if (checkArguments(s) == 1)
        {
            int toReturn = 0;
            int lastDigit = 0;
            int toAdd = 0;
            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == 'I') {
                    toAdd = 1;
                }
                if (s.charAt(i) == 'V') {
                    toAdd = 5;
                }
                if (s.charAt(i) == 'X') {
                    toAdd = 10;
                }
                if (s.charAt(i) == 'L') {
                    toAdd = 50;
                }
                if (s.charAt(i) == 'C') {
                    toAdd = 100;
                }
                if (s.charAt(i) == 'D') {
                    toAdd = 500;
                }
                if (s.charAt(i) == 'M') {
                    toAdd = 1000;
                }
                if (lastDigit >= toAdd || lastDigit == 0) {
                    lastDigit = toAdd;
                    toReturn += toAdd;
                    toAdd = 0;
                } else {
                    toReturn += (toAdd - (2 * lastDigit));
                    lastDigit = toAdd;
                    toAdd = 0;
                }
            }
            return toReturn;
        }
        return 0;
    }
}