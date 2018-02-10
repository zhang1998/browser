package com.uc.encrypt;

import android.content.Context;
import android.util.Log;
import com.alibaba.wireless.security.jaq.JAQException;
import com.uc.apollo.impl.SettingsConst;
import com.uc.encrypt.a.c;
import com.uc.encrypt.a.f;
import java.util.Locale;

/* compiled from: ProGuard */
public final class l {
    private l() {
    }

    public static String a(String str, String str2) throws k {
        if (str2 == null) {
            throw new k(6);
        }
        f b = c.a.b();
        if (b == null) {
            Log.w("AntiSpamHelper", "get not get signature component.");
            throw new k(7);
        }
        try {
            String str3;
            String a = b.a(str, str2);
            d.a();
            byte[] b2 = d.b(Short.valueOf(str).shortValue());
            if (b2 == null || b2.length <= 0) {
                str3 = null;
            } else {
                StringBuffer stringBuffer = new StringBuffer(b2.length * 2);
                for (int i = 0; i < b2.length; i++) {
                    if ((b2[i] & 255) < 16) {
                        stringBuffer.append(SettingsConst.FALSE);
                    }
                    stringBuffer.append(Long.toString((long) (b2[i] & 255), 16));
                }
                str3 = stringBuffer.toString().toLowerCase(Locale.ENGLISH);
            }
            return str3 + a;
        } catch (Throwable e) {
            a(e, e.getErrorCode());
            return null;
        } catch (Throwable e2) {
            a(e2, 2);
            return null;
        }
    }

    public static String a(String str) throws k {
        try {
            d.a();
            return f.a(str, Short.valueOf(d.e()).shortValue());
        } catch (k e) {
            throw e;
        }
    }

    private static void a(Throwable th, int i) {
        Log.e("AntiSpamHelper", "signature failed, error code:" + i);
        throw new k(i, th);
    }

    public static String a(Context context) throws k {
        try {
            return c.a.b().a(context);
        } catch (JAQException e) {
            throw new k(e.getErrorCode());
        } catch (Exception e2) {
            throw new k(2);
        }
    }
}
