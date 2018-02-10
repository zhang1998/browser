package com.uc.base.b.d;

import android.util.Log;
import com.uc.base.b.a.b;
import com.uc.base.b.a.e;
import com.uc.base.b.a.f;
import com.uc.base.b.c.c.a;
import com.uc.base.b.c.d;
import com.uc.base.b.c.i;
import java.io.IOException;

/* compiled from: ProGuard */
public final class c {
    public com.uc.base.b.a.c a;
    public b b;
    private boolean c;
    private byte d;
    private byte e;

    private c(com.uc.base.b.a.c cVar, boolean z, byte b, byte b2) {
        this.a = null;
        this.b = null;
        this.c = z;
        this.a = cVar;
        this.b = f.a(this.a);
        this.d = b;
        this.e = b2;
    }

    public c(com.uc.base.b.a.c cVar) {
        this(cVar, false, (byte) 2, (byte) 0);
    }

    public static final c a(boolean z, byte b, byte b2) {
        return new c(a(), z, b, b2);
    }

    public static com.uc.base.b.a.c a() {
        com.uc.base.b.a.c cVar = new com.uc.base.b.a.c();
        cVar.b = e.a;
        cVar.a = a.a(com.uc.base.b.b.a.a.b(), "/", "main");
        return cVar;
    }

    public static <T extends i> T a(String str, String str2, Class<T> cls) throws a, IOException, b {
        if (a.a(str) || a.a(str2) || cls == null) {
            throw new a("invalid arguments");
        }
        d a = a(false, (byte) 2, (byte) 0).a(str, str2);
        if (a == null) {
            throw new IOException("load fail");
        }
        try {
            i iVar = (i) cls.newInstance();
            if (iVar.a(a)) {
                return iVar;
            }
            throw new b("parse fail");
        } catch (Exception e) {
            throw new a("invalid arguments, class " + cls + " not found");
        }
    }

    private static String a(String str) {
        return str + "/" + com.uc.base.b.b.a.a.a();
    }

    public final boolean a(String str, String str2, byte b, byte[] bArr, boolean z) {
        try {
            com.uc.base.b.c.a.b a = com.uc.base.b.b.a.a(this.d, this.e);
            if (a == null) {
                com.uc.base.b.b.a.a("no encrypt handler for type: " + this.d);
                return false;
            }
            com.uc.base.b.c.a.c a2 = a.a(bArr, b);
            if (a2 == null) {
                com.uc.base.b.b.a.a("encryptionData == null");
                return false;
            }
            String a3;
            if (com.uc.base.b.b.a.a() && a2.f == null) {
                com.uc.base.b.b.a.a("save will fail cause encoded data is empty, please check if the size of data is too large! module path: " + str + ", table name: " + str2 + ", isLang: " + this.c + ", ver: " + b + ", data size: " + bArr.length);
            }
            b bVar = this.b;
            if (this.c) {
                a3 = a(str);
            } else {
                a3 = str;
            }
            byte b2 = a2.b;
            byte[] bArr2 = new byte[16];
            bArr2[0] = com.uc.base.b.c.a.c.a[0];
            bArr2[1] = com.uc.base.b.c.a.c.a[1];
            bArr2[2] = com.uc.base.b.c.a.c.a[2];
            bArr2[3] = com.uc.base.b.c.a.c.a[3];
            bArr2[4] = a2.b;
            bArr2[5] = a2.c;
            bArr2[6] = a2.d;
            bArr2[7] = a2.e;
            return bVar.a(a3, str2, b2, bArr2, a2.f, z);
        } catch (Throwable th) {
            return false;
        }
    }

    public final boolean a(String str, String str2, i iVar, boolean z) {
        if (iVar == null) {
            return false;
        }
        return a(str, str2, iVar.k_(), iVar.l_(), z);
    }

    public final d a(String str, String str2) {
        b bVar = this.b;
        if (this.c) {
            str = a(str);
        }
        com.uc.base.b.a.a a = bVar.a(str, str2);
        byte[] bArr = a.b;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2;
        if (bArr == null || !com.uc.base.b.c.a.c.a(bArr)) {
            bArr2 = null;
        } else {
            byte c = com.uc.base.b.c.a.c.c(bArr);
            byte d = com.uc.base.b.c.a.c.d(bArr);
            com.uc.base.b.c.a.b a2;
            switch (c) {
                case (byte) 1:
                    a2 = com.uc.base.b.b.a.a(c, d);
                    if (a2 != null) {
                        bArr2 = a2.a(bArr, 16);
                        break;
                    }
                    throw new RuntimeException("no appropriate handler for encrypt type:" + c + " !");
                default:
                    a2 = com.uc.base.b.b.a.a(c, d);
                    if (a2 == null) {
                        if (com.uc.base.b.b.a.a()) {
                            com.uc.base.b.b.a.a("error, not support encrypt type: " + c);
                        }
                        bArr2 = null;
                        break;
                    }
                    bArr2 = a2.a(bArr, 16);
                    break;
            }
            if (bArr2 == null) {
                com.uc.base.b.b.a.a("please check why javamodel decoded fail, encryptType = " + c + ", encryptKeyType = " + d);
            }
        }
        if (bArr2 != null) {
            return new d(com.uc.base.b.c.a.c.b(bArr), bArr2, a.a);
        }
        Log.e("EncryptionHandler", "decode error !", new Throwable());
        return null;
    }
}
