package com.lugowoy.helper.reading.readable;

/** Created by Konstantin Lugowoy on 29.07.2017. */

@FunctionalInterface
public interface ReadableCorrect {

    String REGEX_POSITIVE_INTEGER_NUMBER = "\\d+?";
    String REGEX_NEGATIVE_INTEGER_NUMBER = "-\\d+?";

    String REGEX_POSITIVE_REAL_NUMBER = "\\d+?[.]\\d+?";
    String REGEX_NEGATIVE_REAL_NUMBER = "-\\d+?[.]\\d+?";

    boolean isCorrect(String value);

    static boolean isByteNumber(String numberValue) {
        boolean result = false;
        if (numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER) || numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)) {
            if ((Byte.parseByte(numberValue) >= Byte.MIN_VALUE) && (Byte.parseByte(numberValue) <= Byte.MAX_VALUE)) {
                result = true;
            }
        }
        return result;
    }

    static boolean isShortNumber(String numberValue) {
        boolean result = false;
        if (numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER) || numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)) {
            if ((Short.parseShort(numberValue) >= Short.MIN_VALUE) && (Short.parseShort(numberValue) <= Short.MAX_VALUE)) {
                result = true;
            }
        }
        return result;
    }

    static boolean isIntegerNumber(String numberValue) {
        boolean result = false;
        if (numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER) || numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)) {
            if ((Integer.parseInt(numberValue) >= Integer.MIN_VALUE) && (Integer.parseInt(numberValue) <= Integer.MAX_VALUE)) {
                result = true;
            }
        }
        return result;
    }

    static boolean isLongNumber(String numberValue) {
        boolean result = false;
        if (numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER) || numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)) {
            if ((Long.parseLong(numberValue) >= Long.MIN_VALUE) && (Long.parseLong(numberValue) <= Long.MAX_VALUE)) {
                result = true;
            }
        }
        return result;
    }

    static boolean isOnlyCharacter(String characterValue) {
        boolean result = false;
        if (characterValue.length() == 1) {
            if (Character.isDefined(characterValue.charAt(0))) {
                result = true;
            }
        }
        return result;
    }

    static boolean isFloatNumber(String numberValue) {
        boolean result = false;
        if (((numberValue.matches(REGEX_POSITIVE_REAL_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_REAL_NUMBER)))
                || ((numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)))) {
            if ((Float.parseFloat(numberValue) >= Float.MIN_VALUE) || (Float.parseFloat(numberValue) <= Float.MAX_VALUE)) {
                result = true;
            }
        }
        return result;
    }

    static boolean isDoubleNumber(String numberValue) {
        boolean result = false;
        if (((numberValue.matches(REGEX_POSITIVE_REAL_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_REAL_NUMBER)))
                || ((numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)))) {
            if ((Double.parseDouble(numberValue) >= Double.MIN_VALUE) || (Double.parseDouble(numberValue) <= Double.MAX_VALUE)) {
                result = true;
            }
        }
        return result;
    }

}
