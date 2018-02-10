package com.uc.sync.a;

import android.os.Build;
import android.util.Log;
import com.uc.sync.b.b.b;
import com.uc.sync.b.c.c;
import com.ucweb.common.util.d;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* compiled from: ProGuard */
public final class a {
    public static String a = "test client name";
    public static String b = "test client id";
    public static String c = "no sn";
    public static String d = "no imei";
    public static String e = "no pfid";
    public static String f;
    public static String g;
    private static String h = "token=wx6ad620e1ep8nl00yajztagyr9xbzsd​​";

    public static byte[] a(b bVar) {
        byte[] l_ = bVar.l_();
        if (l_ == null) {
            return null;
        }
        l_ = com.uc.sync.c.a.h().a(l_);
        if (l_ == null || l_.length == 0) {
            return null;
        }
        Object d = com.ucweb.common.util.e.a.d(l_);
        if (d == null || d.length == 0) {
            return null;
        }
        byte[] bArr = new byte[(d.length + 16)];
        Object obj = new byte[16];
        Arrays.fill(obj, (byte) 0);
        obj[0] = (byte) 83;
        obj[1] = (byte) 89;
        obj[2] = (byte) 78;
        obj[3] = (byte) 67;
        obj[4] = 2;
        obj[5] = com.uc.sync.c.a.h().g();
        obj[6] = 1;
        System.arraycopy(obj, 0, bArr, 0, 16);
        System.arraycopy(d, 0, bArr, 16, d.length);
        return bArr;
    }

    public static c a(byte[] bArr) {
        int i = 1;
        if (bArr == null) {
            return null;
        }
        if (bArr.length < 16) {
            return null;
        }
        if (bArr[0] != (byte) 83 && bArr[1] != (byte) 89 && bArr[2] != (byte) 78 && bArr[3] != (byte) 67) {
            return null;
        }
        int i2 = bArr[5] == com.uc.sync.c.a.h().g() ? 1 : 0;
        if (bArr[6] != (byte) 1) {
            i = 0;
        }
        Object obj = new byte[(bArr.length - 16)];
        System.arraycopy(bArr, 16, obj, 0, obj.length);
        if (i != 0) {
            byte[] c = com.ucweb.common.util.e.a.c(obj);
        } else {
            Object obj2 = obj;
        }
        if (c == null) {
            Log.e("CLOUDSYNC", "unZip Error!");
            return null;
        }
        if (i2 != 0) {
            c = com.uc.sync.c.a.h().b(c);
        }
        if (c == null) {
            Log.e("CLOUDSYNC", "M9 Decode Error!");
            return null;
        }
        c cVar = new c();
        return !cVar.a(c) ? null : cVar;
    }

    public static byte[] a(String str) {
        byte[] bArr = null;
        if (str != null) {
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        return bArr;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static void a() {
        a = Build.MODEL;
        com.uc.sync.c.a.h();
        d = com.uc.sync.c.a.i();
        com.uc.sync.c.a.h();
        e = com.uc.sync.c.a.k();
        b = d + d.a().getPackageName();
        c = com.uc.sync.c.a.h().a();
        if (com.uc.sync.c.a.h().e()) {
            f = "http://10.20.33.58:8033/sync";
        } else {
            f = com.uc.sync.c.a.h().b();
        }
        com.uc.sync.d.a.a("云同步URL：" + f);
        if (com.uc.sync.c.a.h().f()) {
            g = h;
        } else {
            g = "token=" + com.uc.sync.c.a.h().c();
        }
        com.uc.sync.d.a.a("云同步ticket：" + g);
        com.uc.sync.d.a.a("云同步加密：" + com.uc.sync.c.a.h().g() + "(0:不加;1:M9;2:WXBB)");
    }
}
