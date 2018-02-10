package com.ucpro.feature.c.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: ProGuard */
public final class a {
    public static String a(String str) {
        String str2 = null;
        try {
            str2 = "http://image.baidu.com/wiseshitu?guess=1&queryImageUrl=" + URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        return str2;
    }
}
