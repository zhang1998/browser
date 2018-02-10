package com.ucpro.business.a.a;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* compiled from: ProGuard */
public final class a {
    public static long a(String str, TimeZone timeZone) throws ParseException {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.parse(str).getTime();
    }
}
