package com.uc.framework.xml;

import android.text.Annotation;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;

/* compiled from: ProGuard */
public final class StringBlockModify {
    b a = null;
    private final int b;
    private final boolean c;

    private static final native int nativeCreate(byte[] bArr, int i, int i2);

    private static final native void nativeDestroy(int i);

    private static final native int nativeGetSize(int i);

    private static final native String nativeGetString(int i, int i2);

    private static final native int[] nativeGetStyle(int i, int i2);

    private static final native int nativeIndexOfString(int i, String str);

    public final CharSequence a(int i) {
        CharSequence nativeGetString = nativeGetString(this.b, i);
        int[] nativeGetStyle = nativeGetStyle(this.b, i);
        if (nativeGetStyle == null) {
            return nativeGetString;
        }
        if (this.a == null) {
            this.a = new b();
            this.a.a = nativeIndexOfString(this.b, "b");
            this.a.b = nativeIndexOfString(this.b, "i");
            this.a.c = nativeIndexOfString(this.b, "u");
            this.a.d = nativeIndexOfString(this.b, "tt");
            this.a.e = nativeIndexOfString(this.b, "big");
            this.a.f = nativeIndexOfString(this.b, "small");
            this.a.h = nativeIndexOfString(this.b, "sup");
            this.a.g = nativeIndexOfString(this.b, "sub");
            this.a.i = nativeIndexOfString(this.b, "strike");
            this.a.j = nativeIndexOfString(this.b, "li");
            this.a.k = nativeIndexOfString(this.b, "marquee");
        }
        b bVar = this.a;
        if (nativeGetStyle.length == 0) {
            return nativeGetString;
        }
        CharSequence spannableString = new SpannableString(nativeGetString);
        for (int i2 = 0; i2 < nativeGetStyle.length; i2 += 3) {
            int i3 = nativeGetStyle[i2];
            if (i3 == bVar.a) {
                spannableString.setSpan(new StyleSpan(1), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
            } else if (i3 == bVar.b) {
                spannableString.setSpan(new StyleSpan(2), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
            } else if (i3 == bVar.c) {
                spannableString.setSpan(new UnderlineSpan(), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
            } else if (i3 == bVar.d) {
                spannableString.setSpan(new TypefaceSpan("monospace"), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
            } else if (i3 == bVar.e) {
                spannableString.setSpan(new RelativeSizeSpan(1.25f), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
            } else if (i3 == bVar.f) {
                spannableString.setSpan(new RelativeSizeSpan(0.8f), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
            } else if (i3 == bVar.g) {
                spannableString.setSpan(new SubscriptSpan(), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
            } else if (i3 == bVar.h) {
                spannableString.setSpan(new SuperscriptSpan(), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
            } else if (i3 == bVar.i) {
                spannableString.setSpan(new StrikethroughSpan(), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
            } else if (i3 == bVar.j) {
                a(spannableString, new BulletSpan(10), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1);
            } else if (i3 == bVar.k) {
                spannableString.setSpan(TruncateAt.MARQUEE, nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 18);
            } else {
                String nativeGetString2 = nativeGetString(this.b, i3);
                String a;
                if (nativeGetString2.startsWith("font;")) {
                    a = a(nativeGetString2, ";height=");
                    if (a != null) {
                        a(spannableString, new a(Integer.parseInt(a)), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1);
                    }
                    a = a(nativeGetString2, ";size=");
                    if (a != null) {
                        spannableString.setSpan(new AbsoluteSizeSpan(Integer.parseInt(a)), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
                    }
                    a = a(nativeGetString2, ";fgcolor=");
                    if (a != null) {
                        spannableString.setSpan(new ForegroundColorSpan(c.a(a)), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
                    }
                    a = a(nativeGetString2, ";bgcolor=");
                    if (a != null) {
                        spannableString.setSpan(new BackgroundColorSpan(c.a(a)), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
                    }
                } else if (nativeGetString2.startsWith("a;")) {
                    a = a(nativeGetString2, ";href=");
                    if (a != null) {
                        spannableString.setSpan(new URLSpan(a), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
                    }
                } else if (nativeGetString2.startsWith("annotation;")) {
                    int length = nativeGetString2.length();
                    int indexOf = nativeGetString2.indexOf(59);
                    while (indexOf < length) {
                        int indexOf2 = nativeGetString2.indexOf(61, indexOf);
                        if (indexOf2 < 0) {
                            break;
                        }
                        i3 = nativeGetString2.indexOf(59, indexOf2);
                        if (i3 < 0) {
                            i3 = length;
                        }
                        spannableString.setSpan(new Annotation(nativeGetString2.substring(indexOf + 1, indexOf2), nativeGetString2.substring(indexOf2 + 1, i3)), nativeGetStyle[i2 + 1], nativeGetStyle[i2 + 2] + 1, 33);
                        indexOf = i3;
                    }
                }
            }
        }
        return new SpannedString(spannableString);
    }

    protected final void finalize() throws Throwable {
        if (this.c) {
            nativeDestroy(this.b);
        }
    }

    private static void a(Spannable spannable, Object obj, int i, int i2) {
        int length = spannable.length();
        if (i != 0 && i != length && spannable.charAt(i - 1) != '\n') {
            while (true) {
                i--;
                if (i <= 0 || spannable.charAt(i - 1) == '\n') {
                    break;
                }
            }
        }
        if (i2 != 0 && i2 != length && spannable.charAt(i2 - 1) != '\n') {
            while (true) {
                i2++;
                if (i2 >= length || spannable.charAt(i2 - 1) == '\n') {
                    break;
                }
            }
        }
        spannable.setSpan(obj, i, i2, 51);
    }

    private static String a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            return null;
        }
        indexOf += str2.length();
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 < 0) {
            return str.substring(indexOf);
        }
        return str.substring(indexOf, indexOf2);
    }

    StringBlockModify(int i) {
        this.b = i;
        this.c = false;
    }
}
