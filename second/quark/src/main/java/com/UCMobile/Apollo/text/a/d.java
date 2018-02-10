package com.UCMobile.Apollo.text.a;

import com.UCMobile.Apollo.b;
import com.UCMobile.Apollo.util.c;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class d {
    private static final Pattern a = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    public static void a(c cVar) throws b {
        Object a = cVar.a();
        if (a == null || !a.matcher(a).matches()) {
            throw new b("Expected WEBVTT. Got " + a);
        }
    }

    public static long a(String str) throws NumberFormatException {
        int i = 0;
        long j = 0;
        String[] split = str.split("\\.", 2);
        String[] split2 = split[0].split(":");
        while (i < split2.length) {
            j = (j * 60) + Long.parseLong(split2[i]);
            i++;
        }
        return (Long.parseLong(split[1]) + (j * 1000)) * 1000;
    }

    public static float b(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }
}
