package com.loc;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.uc.apollo.impl.SettingsConst;
import com.uc.crashsdk.export.LogType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/* compiled from: ProGuard */
public final class eg {
    public static String a() {
        String str;
        Throwable th;
        Throwable th2;
        String str2 = null;
        try {
            str2 = String.valueOf(System.currentTimeMillis());
            try {
                str = SettingsConst.TRUE;
                int length = str2.length();
                str = str2.substring(0, length - 2) + str + str2.substring(length - 1);
            } catch (Throwable th3) {
                th = th3;
                str = str2;
                th2 = th;
                es.a(th2, "CInfo", "getTS");
                return str;
            }
        } catch (Throwable th32) {
            th = th32;
            str = str2;
            th2 = th;
            es.a(th2, "CInfo", "getTS");
            return str;
        }
        return str;
    }

    public static String a(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = ek.b(dx.e(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            es.a(th, "CInfo", "Scode");
        }
        return str3;
    }

    public static String a(Context context, byte[] bArr) {
        try {
            return b(bArr);
        } catch (Throwable th) {
            es.a(th, "CInfo", "AESData");
            return "";
        }
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            eq.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        } else {
            eq.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, eq.a(str));
        }
    }

    private static byte[] a(ef efVar) {
        Throwable th;
        Throwable th2;
        byte[] bArr = null;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                a(byteArrayOutputStream, efVar.a);
                a(byteArrayOutputStream, efVar.b);
                a(byteArrayOutputStream, efVar.c);
                a(byteArrayOutputStream, efVar.d);
                a(byteArrayOutputStream, efVar.e);
                a(byteArrayOutputStream, efVar.f);
                a(byteArrayOutputStream, efVar.g);
                a(byteArrayOutputStream, efVar.h);
                a(byteArrayOutputStream, efVar.i);
                a(byteArrayOutputStream, efVar.j);
                a(byteArrayOutputStream, efVar.k);
                a(byteArrayOutputStream, efVar.l);
                a(byteArrayOutputStream, efVar.m);
                a(byteArrayOutputStream, efVar.n);
                a(byteArrayOutputStream, efVar.o);
                a(byteArrayOutputStream, efVar.p);
                a(byteArrayOutputStream, efVar.q);
                a(byteArrayOutputStream, efVar.r);
                a(byteArrayOutputStream, efVar.s);
                a(byteArrayOutputStream, efVar.t);
                byte[] b = eq.b(byteArrayOutputStream.toByteArray());
                Key b2 = eq.b();
                if (b.length > 117) {
                    byte[] bArr2 = new byte[117];
                    System.arraycopy(b, 0, bArr2, 0, 117);
                    Object a = ej.a(bArr2, b2);
                    Object obj = new byte[((b.length + 128) - 117)];
                    System.arraycopy(a, 0, obj, 0, 128);
                    System.arraycopy(b, 117, obj, 128, b.length - 117);
                    bArr = obj;
                } else {
                    bArr = ej.a(b, b2);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    es.a(th, "CInfo", "InitXInfo");
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th5) {
                        }
                    }
                    return bArr;
                } catch (Throwable th6) {
                    th2 = th6;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th7) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th8) {
            byteArrayOutputStream = bArr;
            th2 = th8;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th2;
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(LogType.UNEXP);
        byte[] encoded = instance.generateKey().getEncoded();
        Key b = eq.b();
        if (b == null) {
            return null;
        }
        Object a = ej.a(encoded, b);
        Object a2 = ej.a(encoded, bArr);
        Object obj = new byte[(a.length + a2.length)];
        System.arraycopy(a, 0, obj, 0, a.length);
        System.arraycopy(a2, 0, obj, a.length, a2.length);
        return obj;
    }

    public static String b(Context context, byte[] bArr) {
        try {
            return b(bArr);
        } catch (Throwable th) {
            return "";
        }
    }

    private static String b(byte[] bArr) throws InvalidKeyException, IOException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, CertificateException {
        byte[] b = eq.b(a(bArr));
        return b != null ? ej.a(b) : "";
    }

    public static byte[] a(Context context) {
        try {
            ef efVar = new ef();
            efVar.a = ei.q(context);
            efVar.b = ei.i(context);
            String f = ei.f(context);
            if (f == null) {
                f = "";
            }
            efVar.c = f;
            efVar.d = dx.c(context);
            efVar.e = Build.MODEL;
            efVar.f = Build.MANUFACTURER;
            efVar.g = Build.DEVICE;
            efVar.h = dx.b(context);
            efVar.i = dx.d(context);
            efVar.j = String.valueOf(VERSION.SDK_INT);
            efVar.k = ei.r(context);
            efVar.l = ei.p(context);
            efVar.m = ei.m(context);
            efVar.n = ei.l(context);
            efVar.o = ei.s(context);
            efVar.p = ei.k(context);
            efVar.q = ei.h(context);
            efVar.r = ei.g(context);
            String[] j = ei.j(context);
            efVar.s = j[0];
            efVar.t = j[1];
            return a(efVar);
        } catch (Throwable th) {
            es.a(th, "CInfo", "getGZipXInfo");
            return null;
        }
    }
}
