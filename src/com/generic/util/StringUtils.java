package com.generic.util;

import org.jsoup.Jsoup;
public class StringUtils {
    public static String unescapeHtml(String text) {
    return  Jsoup.parse(text).text();
    }
}