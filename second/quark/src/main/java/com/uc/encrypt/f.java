package com.uc.encrypt;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.uc.encrypt.a.a;
import com.uc.webview.export.cd.CDController;
import com.ucweb.common.util.annotation.Invoker;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import java.nio.charset.Charset;

/* compiled from: ProGuard */
public final class f {
    private static a a;
    private static int b = 2;

    public static void a(Context context, boolean z, byte b) {
        d.a = z;
        m.a(0, new b(b, context));
    }

    public static void a() {
        try {
            System.loadLibrary(CDController.JSON_CD_ENCRYPT_KEY);
        } catch (Exception e) {
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        switch (e.a[i - 1]) {
            case 1:
                return a(bArr, d.a().b(), false);
            case 2:
                return M9EncryptionHandler.a().encodeM9(bArr);
            case 3:
                return m.b(bArr, m.d);
            default:
                c.a("unsupported encrypt method");
                throw new UnsupportedOperationException("unsupported encrypt method");
        }
    }

    public static String a(String str, int i) {
        byte[] bArr = null;
        switch (e.a[i - 1]) {
            case 1:
                try {
                    return a(str);
                } catch (Exception e) {
                    c.a(e.toString());
                    if (!com.ucweb.common.util.n.a.a(str)) {
                        bArr = str.getBytes(Charset.forName("UTF-8"));
                    }
                    bArr = M9EncryptionHandler.a().encodeM9(bArr);
                    if (bArr != null) {
                        return Base64.encodeToString(bArr, 2);
                    }
                    if (!com.ucweb.common.util.n.a.a(str)) {
                        bArr = str.getBytes(Charset.forName("UTF-8"));
                    }
                    bArr = m.b(bArr, m.d);
                    if (bArr != null) {
                        return Base64.encodeToString(bArr, 2);
                    }
                    c.a("unsupported encrypt method");
                    throw new UnsupportedOperationException("unknown encrypt method");
                }
            case 2:
                break;
            case 3:
                break;
        }
    }

    public static String a(String str) {
        return a(str, d.a().b(), false);
    }

    public static String b(String str) {
        return c(str);
    }

    public static byte[] b(byte[] bArr, int i) {
        switch (e.a[i - 1]) {
            case 1:
                return c(bArr);
            case 2:
                return M9EncryptionHandler.a().decodeM9(bArr);
            case 3:
                return m.a(bArr, m.d);
            default:
                c.a("unsupported encrypt method");
                throw new UnsupportedOperationException("unsupported encrypt method");
        }
    }

    private static a d() {
        if (a == null) {
            try {
                a = com.uc.encrypt.a.c.a.a();
            } catch (Throwable e) {
                b(e, e.getErrorCode());
            } catch (Throwable e2) {
                b(e2, 2);
            }
        }
        return a;
    }

    private static void b(Throwable th, int i) {
        c.a("encrypt failed, error code:" + i + "Throwable: " + th);
    }

    private static String c(String str) {
        if (com.ucweb.common.util.n.a.a(str)) {
            return "";
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            if (decode == null) {
                return "";
            }
            byte[] c = c(decode);
            if (c == null) {
                return "";
            }
            return new String(c);
        } catch (Exception e) {
            c.a(e.toString());
            return "";
        }
    }

    private static byte[] c(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
                if (bArr.length >= b) {
                    if (bArr.length == b) {
                        Log.e("EncryptHelper", "no valid data section after prefix, return null");
                    } else {
                        byte[] bArr3 = new byte[b];
                        System.arraycopy(bArr, 0, bArr3, 0, bArr3.length);
                        d.a();
                        String a = d.a().a(d.a(bArr3));
                        if (a != null) {
                            a d = d();
                            if (d == null) {
                                Log.e("EncryptHelper", "get encrypt component failed");
                            } else {
                                Object obj = new byte[(bArr.length - b)];
                                System.arraycopy(bArr, b, obj, 0, obj.length);
                                bArr2 = d.b(a, obj);
                            }
                        }
                    }
                    return bArr2;
                }
            } catch (Throwable e) {
                e.getErrorCode();
                c.a(e.toString());
            } catch (Throwable e2) {
                c.a(e2.toString());
            }
        }
        Log.e("EncryptHelper", "invalid data format, not include prefix bytes");
        return bArr2;
    }

    private static byte[] a(byte[] bArr, short s, boolean z) {
        a d = d();
        if (d == null) {
            Log.e("EncryptHelper", "get encrypt component failed");
            if (!z) {
                return null;
            }
            throw new k(4);
        }
        String a = d.a().a(s);
        if (a != null) {
            try {
                d.a();
                Object b = d.b(s);
                Object obj;
                if (bArr == null || bArr.length == 0) {
                    obj = new byte[b.length];
                    System.arraycopy(b, 0, obj, 0, b.length);
                    return obj;
                }
                Object a2 = d.a(a, bArr);
                obj = new byte[(b.length + a2.length)];
                System.arraycopy(b, 0, obj, 0, b.length);
                System.arraycopy(a2, 0, obj, b.length, a2.length);
                return obj;
            } catch (Throwable e) {
                b(e, e.getErrorCode());
                if (!z) {
                    return null;
                }
                throw new k(e.getErrorCode(), e);
            } catch (Throwable e2) {
                b(e2, 2);
                if (!z) {
                    return null;
                }
                k kVar = new k(2, e2);
            }
        } else if (!z) {
            return null;
        } else {
            throw new k(3);
        }
    }

    private static String a(String str, short s, boolean z) throws k {
        String str2 = "";
        byte[] bArr = null;
        try {
            if (!com.ucweb.common.util.n.a.a(str)) {
                bArr = str.getBytes(Charset.forName("UTF-8"));
            }
            bArr = a(bArr, s, z);
            if (bArr != null) {
                str2 = Base64.encodeToString(bArr, 2);
            }
        } catch (k e) {
            c.a(e.toString());
            if (z) {
                throw e;
            }
        } catch (Throwable th) {
            c.a(th.toString());
            if (z) {
                k kVar = new k(5);
            }
        }
        return str2;
    }

    public static String a(String str, short s) {
        return a(str, s, true);
    }

    public static String a(String str, String str2) {
        try {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(d.a());
            if (instance != null) {
                return instance.getStaticDataStoreComp().getExtraData(str, str2);
            }
        } catch (SecException e) {
        }
        return "";
    }

    @Invoker(type = com.ucweb.common.util.annotation.a.Native)
    public static byte[] a(byte[] bArr) {
        return a(bArr, a.c);
    }

    @Invoker(type = com.ucweb.common.util.annotation.a.Native)
    public static byte[] b(byte[] bArr) {
        return b(bArr, a.c);
    }

    static /* synthetic */ void c() {
        d.a();
        d.c();
    }

    static /* synthetic */ void a(Throwable th, int i) {
        d.a();
        d.c();
        c.a("init error code:" + i + "error log:" + th);
    }
}
