package com.taobao.weex.b.b;

import com.taobao.weex.utils.WXLogUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: ProGuard */
public final class f {
    private static SimpleDateFormat a;
    private static SimpleDateFormat b;

    public static Date a(String str) {
        if (b == null) {
            b = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        }
        try {
            return b.parse(str);
        } catch (ParseException e) {
            WXLogUtils.w("[DatePickerImpl] " + e.toString());
            return new Date();
        }
    }

    public static Date b(String str) {
        if (a == null) {
            a = new SimpleDateFormat("HH:mm", Locale.getDefault());
        }
        try {
            return a.parse(str);
        } catch (ParseException e) {
            WXLogUtils.w("[DatePickerImpl] " + e.toString());
            return new Date();
        }
    }
}
