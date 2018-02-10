package com.alibaba.analytics.core.g;

import android.content.Context;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.b;
import com.e.b.d.a.c;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public class a {
    private static volatile a b;
    public boolean a = false;
    private Object c = null;
    private Object d = null;
    private Method e = null;
    private Object f = null;
    private Method g = null;
    private Method h = null;
    private String i = "";

    private a() {
    }

    public static a a() {
        if (b != null) {
            return b;
        }
        a aVar;
        synchronized (a.class) {
            aVar = new a();
            b = aVar;
            aVar.b();
            aVar = b;
        }
        return aVar;
    }

    private synchronized void b() {
        af.b();
        try {
            c cVar = b.a().e;
            if (cVar != null) {
                Class cls = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
                Class cls2 = Class.forName("com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent");
                Class cls3 = Class.forName("com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent");
                if (cVar instanceof com.e.b.d.a.b) {
                    this.i = ((com.e.b.d.a.b) cVar).b;
                }
                if (cls == null || cls2 == null || cls3 == null) {
                    this.a = false;
                } else {
                    this.c = cls.getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{b.a().b});
                    this.d = cls.getMethod("getStaticDataEncryptComp", new Class[0]).invoke(this.c, new Object[0]);
                    this.f = cls.getMethod("getDynamicDataStoreComp", new Class[0]).invoke(this.c, new Object[0]);
                    this.e = cls2.getMethod("staticBinarySafeDecryptNoB64", new Class[]{Integer.TYPE, String.class, byte[].class, String.class});
                    this.g = cls3.getMethod("putByteArray", new Class[]{String.class, byte[].class});
                    this.h = cls3.getMethod("getByteArray", new Class[]{String.class});
                    this.a = true;
                }
            }
        } catch (Throwable th) {
            this.a = false;
            af.d("initSecurityCheck", "e.getCode", th.getCause(), th, th.getMessage());
        }
    }

    public final byte[] a(String str, byte[] bArr) {
        if (this.e == null || this.d == null) {
            return null;
        }
        try {
            Object invoke = this.e.invoke(this.d, new Object[]{Integer.valueOf(16), str, bArr, this.i});
            af.b("", "mStaticDataEncryptCompObj", this.d, "i", Integer.valueOf(16), "str", str, "bArr", bArr, "authcode", this.i, "obj", invoke);
            if (invoke == null) {
                return null;
            }
            return (byte[]) invoke;
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
            return null;
        }
    }

    public final int b(String str, byte[] bArr) {
        if (this.g == null || this.f == null) {
            return 0;
        }
        try {
            Object invoke = this.g.invoke(this.f, new Object[]{str, bArr});
            if (invoke == null) {
                return 0;
            }
            af.a("", "ret", Integer.valueOf(((Integer) invoke).intValue()));
            return ((Integer) invoke).intValue();
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
            return -1;
        }
    }

    public final byte[] a(String str) {
        if (this.h == null || this.f == null) {
            return null;
        }
        try {
            Object invoke = this.h.invoke(this.f, new Object[]{str});
            if (invoke == null) {
                return null;
            }
            return (byte[]) invoke;
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
            return null;
        }
    }
}
