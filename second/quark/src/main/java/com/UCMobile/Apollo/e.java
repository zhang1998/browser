package com.UCMobile.Apollo;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

/* compiled from: ProGuard */
public final class e {
    private static final String[] a = new String[]{"K", "M", "G", "T", "P"};

    public static boolean a(String str) {
        return str == null || "".equals(str);
    }

    public static String b(String str) {
        try {
            URL url = new URL(str);
            if (url.getProtocol() == null) {
                return str;
            }
            if ("file".equals(url.getProtocol())) {
                return URLDecoder.decode(url.toString(), "UTF-8");
            }
            return url.toString();
        } catch (MalformedURLException e) {
            return str;
        } catch (UnsupportedEncodingException e2) {
            return str;
        }
    }
}
