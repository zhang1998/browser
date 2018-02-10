package com.ui.edittext;

import android.text.NoCopySpan.Concrete;
import android.text.Spannable;
import android.text.Spanned;
import com.uc.crashsdk.export.LogType;

/* compiled from: ProGuard */
public abstract class g {
    private static final Object a = new Concrete();
    private static final Object b = new Concrete();
    private static final Object c = new Concrete();
    private static final Object d = new Concrete();

    public static void a(Spannable spannable) {
        spannable.removeSpan(a);
        spannable.removeSpan(b);
        spannable.removeSpan(c);
        spannable.removeSpan(d);
    }

    public static final int a(CharSequence charSequence) {
        return ((a(charSequence, a, 1, LogType.UNEXP) | a(charSequence, b, 2, 512)) | a(charSequence, c, 4, 1024)) | a(charSequence, d, 2048, 2048);
    }

    public static final int a(CharSequence charSequence, int i) {
        switch (i) {
            case 1:
                return a(charSequence, a, 1, 2);
            case 2:
                return a(charSequence, b, 1, 2);
            case 4:
                return a(charSequence, c, 1, 2);
            case 2048:
                return a(charSequence, d, 1, 2);
            default:
                return 0;
        }
    }

    private static int a(CharSequence charSequence, Object obj, int i, int i2) {
        if (!(charSequence instanceof Spanned)) {
            return 0;
        }
        int spanFlags = ((Spanned) charSequence).getSpanFlags(obj);
        if (spanFlags == 67108881) {
            return i2;
        }
        if (spanFlags != 0) {
            return i;
        }
        return 0;
    }

    public static void b(Spannable spannable) {
        a(spannable, a);
        a(spannable, b);
        a(spannable, c);
    }

    public static boolean a(Object obj) {
        return obj == a || obj == b || obj == c || obj == d;
    }

    public static boolean b(Object obj) {
        return obj == d;
    }

    private static void a(Spannable spannable, Object obj) {
        int spanFlags = spannable.getSpanFlags(obj);
        if (spanFlags == 16777233) {
            spannable.setSpan(obj, 0, 0, 50331665);
        } else if (spanFlags == 33554449) {
            spannable.removeSpan(obj);
        }
    }

    protected static void c(Spannable spannable) {
        b(spannable, a);
        b(spannable, b);
        b(spannable, c);
        b(spannable, d);
    }

    private static void b(Spannable spannable, Object obj) {
        if (spannable.getSpanFlags(obj) == 67108881) {
            spannable.removeSpan(obj);
        }
    }

    public static void d(Spannable spannable) {
        spannable.setSpan(d, 0, 0, 16777233);
    }

    public static void e(Spannable spannable) {
        spannable.removeSpan(d);
    }
}
