package com.f.a.c;

import android.content.Context;
import com.f.a.b.a.b;
import com.f.a.b.a.c;
import java.util.zip.Adler32;

/* compiled from: ProGuard */
public final class a {
    static String a = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
    static final Object b = new Object();
    private static d c = null;

    private static d b(Context context) {
        if (context != null) {
            d dVar = new d();
            synchronized (b) {
                String a = c.a(context).a();
                if (!c.a(a)) {
                    String substring;
                    if (a.endsWith("\n")) {
                        substring = a.substring(0, a.length() - 1);
                    } else {
                        substring = a;
                    }
                    dVar = new d();
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = b.a(context);
                    String b = b.b(context);
                    dVar.c = a2;
                    dVar.a = a2;
                    dVar.e = currentTimeMillis;
                    dVar.b = b;
                    dVar.d = substring;
                    substring = String.format("%s%s%s%s%s", new Object[]{dVar.d, dVar.c, Long.valueOf(dVar.e), dVar.b, dVar.a});
                    if (c.a(substring)) {
                        currentTimeMillis = 0;
                    } else {
                        Adler32 adler32 = new Adler32();
                        adler32.reset();
                        adler32.update(substring.getBytes());
                        currentTimeMillis = adler32.getValue();
                    }
                    dVar.f = currentTimeMillis;
                    return dVar;
                }
            }
        }
        return null;
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (a.class) {
            if (c != null) {
                dVar = c;
            } else if (context != null) {
                dVar = b(context);
                c = dVar;
            } else {
                dVar = null;
            }
        }
        return dVar;
    }
}
