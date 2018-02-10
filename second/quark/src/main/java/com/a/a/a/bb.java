package com.a.a.a;

import android.content.Context;
import java.io.File;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: ProGuard */
public final class bb {
    static final byte[] a = "pbl0".getBytes();
    private static bb f;
    ed b;
    ar c = new ar();
    dx d = null;
    Context e;

    private bb(Context context) {
        this.e = context;
    }

    public static synchronized bb a(Context context) {
        byte[] b;
        bb bbVar;
        Throwable th;
        InputStream inputStream = null;
        synchronized (bb.class) {
            if (f == null) {
                bb bbVar2 = new bb(context);
                f = bbVar2;
                if (new File(bbVar2.e.getFilesDir(), ".imprint").exists()) {
                    dx dxVar;
                    InputStream openFileInput;
                    try {
                        openFileInput = bbVar2.e.openFileInput(".imprint");
                        try {
                            b = fu.b(openFileInput);
                            fu.c(openFileInput);
                        } catch (Exception e) {
                            fu.c(openFileInput);
                            if (b != null) {
                                try {
                                    dxVar = new dx();
                                    new b().a(dxVar, b);
                                    bbVar2.d = dxVar;
                                    bbVar2.c.a(dxVar);
                                } catch (Exception e2) {
                                }
                            }
                            bbVar = f;
                            return bbVar;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            inputStream = openFileInput;
                            th = th3;
                            fu.c(inputStream);
                            throw th;
                        }
                    } catch (Exception e3) {
                        openFileInput = inputStream;
                        fu.c(openFileInput);
                        if (b != null) {
                            dxVar = new dx();
                            new b().a(dxVar, b);
                            bbVar2.d = dxVar;
                            bbVar2.c.a(dxVar);
                        }
                        bbVar = f;
                        return bbVar;
                    } catch (Throwable th4) {
                        th = th4;
                        fu.c(inputStream);
                        throw th;
                    }
                    if (b != null) {
                        dxVar = new dx();
                        new b().a(dxVar, b);
                        bbVar2.d = dxVar;
                        bbVar2.c.a(dxVar);
                    }
                }
            }
            bbVar = f;
        }
        return bbVar;
    }

    public static String a(dx dxVar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : new TreeMap(dxVar.a).entrySet()) {
            stringBuilder.append((String) entry.getKey());
            if (((dr) entry.getValue()).a()) {
                stringBuilder.append(((dr) entry.getValue()).a);
            }
            stringBuilder.append(((dr) entry.getValue()).b);
            stringBuilder.append(((dr) entry.getValue()).c);
        }
        stringBuilder.append(dxVar.b);
        return fu.a(stringBuilder.toString()).toLowerCase(Locale.US);
    }

    static dx a(dx dxVar, dx dxVar2) {
        if (dxVar2 != null) {
            Map map = dxVar.a;
            for (Entry entry : dxVar2.a.entrySet()) {
                if (((dr) entry.getValue()).a()) {
                    map.put(entry.getKey(), entry.getValue());
                } else {
                    map.remove(entry.getKey());
                }
            }
            dxVar.b = dxVar2.b;
            dxVar.b();
            dxVar.c = a(dxVar);
        }
        return dxVar;
    }

    public final synchronized dx a() {
        return this.d;
    }
}
