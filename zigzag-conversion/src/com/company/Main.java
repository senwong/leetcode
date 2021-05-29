package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("test1: ");
        String ret = convert2("PAYPALISHIRING", 3);
        System.out.println("ret: "+ ret + ", "  + (ret.equals("PAHNAPLSIIGYIR")));

        System.out.println("test2: ");
        String ret2 = convert2("PAYPALISHIRING", 4);
        System.out.println("ret: "+ ret + ", "  + (ret2.equals("PINALSIGYAHRPI")));
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        int curRow = 0;

        boolean isDown = true;
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        for (int i = 0; i < s.length(); i++) {
            rows.get(curRow).append(s.charAt(i));

            if (isDown && curRow == numRows - 1) {
                isDown = false;
            } else if (!isDown && curRow == 0) {
                isDown = true;
            }

            curRow = isDown ? curRow + 1 : curRow - 1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row.toString());
        return ret.toString();
    }

    public static String convert2(String s, int numRows) {
        if (numRows < 2) return s;

        int unitStrLen = 2 * numRows - 2;

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += unitStrLen) {
                ret.append(s.charAt(j));
                if (i > 0 & i < numRows - 1) {
                   int another =  j + (numRows - i - 1) * 2;
//                   System.out.println("j: " + j + ", another: "+ another);
                   if (another < s.length()) {
                       ret.append(s.charAt(another));
                   }
                }
            }
        }
        return ret.toString();
    }
}
