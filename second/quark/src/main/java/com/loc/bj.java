package com.loc;

import android.content.Context;
import com.uc.crashsdk.export.LogType;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class bj extends bp {
    protected Context a;
    protected ep b;

    public bj(Context context, ep epVar) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = epVar;
    }

    private static byte[] a(byte[] bArr) {
        byte length = (byte) (bArr.length % LogType.UNEXP);
        return new byte[]{(byte) (bArr.length / LogType.UNEXP), length};
    }

    private static byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(eq.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{(byte) 1});
            byteArrayOutputStream.write(new byte[]{(byte) 0});
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return toByteArray;
            } catch (Throwable th) {
                es.a(th, "BinaryRequest", "getBinaryHead");
                return toByteArray;
            }
        } catch (Throwable th2) {
            es.a(th2, "BinaryRequest", "getBinaryHead");
        }
        return null;
    }

    private byte[] k() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] a;
            byteArrayOutputStream.write(new byte[]{(byte) 3});
            if (d()) {
                a = eg.a(this.a);
                byteArrayOutputStream.write(a(a));
                byteArrayOutputStream.write(a);
            } else {
                byteArrayOutputStream.write(new byte[]{(byte) 0, (byte) 0});
            }
            a = eq.a(g());
            if (a == null || a.length <= 0) {
                byteArrayOutputStream.write(new byte[]{(byte) 0, (byte) 0});
            } else {
                byteArrayOutputStream.write(a(a));
                byteArrayOutputStream.write(a);
            }
            a = eq.a(f());
            if (a == null || a.length <= 0) {
                byteArrayOutputStream.write(new byte[]{(byte) 0, (byte) 0});
            } else {
                byteArrayOutputStream.write(a(a));
                byteArrayOutputStream.write(a);
            }
            a = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return a;
            } catch (Throwable th) {
                es.a(th, "BinaryRequest", "getRequestEncryptData");
                return a;
            }
        } catch (Throwable th2) {
            es.a(th2, "BinaryRequest", "getRequestEncryptData");
        }
        return new byte[]{(byte) 0};
    }

    private byte[] l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] h = h();
            if (h == null || h.length == 0) {
                byteArrayOutputStream.write(new byte[]{(byte) 0});
                h = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return h;
                } catch (Throwable th) {
                    es.a(th, "BinaryRequest", "getRequestRawData");
                    return h;
                }
            }
            byteArrayOutputStream.write(new byte[]{(byte) 1});
            byteArrayOutputStream.write(a(h));
            byteArrayOutputStream.write(h);
            h = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return h;
            } catch (Throwable th2) {
                es.a(th2, "BinaryRequest", "getRequestRawData");
                return h;
            }
        } catch (Throwable th3) {
            es.a(th3, "BinaryRequest", "getRequestRawData");
        }
        return new byte[]{(byte) 0};
    }

    private byte[] m() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] i = i();
            if (i == null || i.length == 0) {
                byteArrayOutputStream.write(new byte[]{(byte) 0});
                i = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return i;
                } catch (Throwable th) {
                    es.a(th, "BinaryRequest", "getRequestEncryptData");
                    return i;
                }
            }
            byteArrayOutputStream.write(new byte[]{(byte) 1});
            i = eg.a(i);
            byteArrayOutputStream.write(a(i));
            byteArrayOutputStream.write(i);
            i = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return i;
            } catch (Throwable th2) {
                es.a(th2, "BinaryRequest", "getRequestEncryptData");
                return i;
            }
        } catch (Throwable th3) {
            es.a(th3, "BinaryRequest", "getRequestEncryptData");
        }
        return new byte[]{(byte) 0};
    }

    public Map<String, String> a() {
        String f = dx.f(this.a);
        String a = eg.a();
        String a2 = eg.a(this.a, a, "key=" + f);
        Map<String, String> hashMap = new HashMap();
        hashMap.put("ts", a);
        hashMap.put("key", f);
        hashMap.put("scode", a2);
        return hashMap;
    }

    public boolean d() {
        return true;
    }

    public final byte[] e() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(j());
            byteArrayOutputStream.write(k());
            byteArrayOutputStream.write(l());
            byteArrayOutputStream.write(m());
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return toByteArray;
            } catch (Throwable th) {
                es.a(th, "BinaryRequest", "getEntityBytes");
                return toByteArray;
            }
        } catch (Throwable th2) {
            es.a(th2, "BinaryRequest", "getEntityBytes");
        }
        return null;
    }

    public String f() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.b.b(), this.b.a()});
    }

    protected String g() {
        return "2.1";
    }

    public abstract byte[] h();

    public abstract byte[] i();
}
