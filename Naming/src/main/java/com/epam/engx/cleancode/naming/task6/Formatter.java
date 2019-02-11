package com.epam.engx.cleancode.naming.task6;

public class Formatter {

    private static final String PLUS_SYMBOL = "+";
    private static final String PIPE_SYMBOL = "|";
    private static final String MINUS_SYMBOL = "-";
    private static final String UNDERSCORE_SYMBOL = " _ ";

    public static void main(String[] args) {
        System.out.println(formatKyeValue("enable", "true"));
        System.out.println(formatKyeValue("name", "Bob"));
    }

    private static String formatKyeValue(String key, String value) {
        String content = key + UNDERSCORE_SYMBOL + value;
        String minuses = repeat(MINUS_SYMBOL, content.length());

        return PLUS_SYMBOL + minuses + PLUS_SYMBOL + "\n"
                + PIPE_SYMBOL + content + PIPE_SYMBOL + "\n" +
                PLUS_SYMBOL + minuses + PLUS_SYMBOL + "\n";
    }

    private static String repeat(String symbol, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++)
            result.append(symbol);

        return result.toString();
    }
}
