package com.ucpro.b.b;

import com.uc.apollo.impl.SettingsConst;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: ProGuard */
public final class b {
    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 255) < 16) {
                stringBuffer.append(SettingsConst.FALSE);
            }
            stringBuffer.append(Long.toString((long) (bArr[i] & 255), 16));
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r6) {
        /*
        r0 = 0;
        r1 = "MD5";
        r2 = java.security.MessageDigest.getInstance(r1);	 Catch:{ FileNotFoundException -> 0x003f, IOException -> 0x002f, Throwable -> 0x0035 }
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x003f, IOException -> 0x002f, Throwable -> 0x0035 }
        r1.<init>(r6);	 Catch:{ FileNotFoundException -> 0x003f, IOException -> 0x002f, Throwable -> 0x0035 }
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r3 = new byte[r3];	 Catch:{ FileNotFoundException -> 0x001c, IOException -> 0x003d, Throwable -> 0x003b }
    L_0x0010:
        r4 = r1.read(r3);	 Catch:{ FileNotFoundException -> 0x001c, IOException -> 0x003d, Throwable -> 0x003b }
        r5 = -1;
        if (r4 == r5) goto L_0x0021;
    L_0x0017:
        r5 = 0;
        r2.update(r3, r5, r4);	 Catch:{ FileNotFoundException -> 0x001c, IOException -> 0x003d, Throwable -> 0x003b }
        goto L_0x0010;
    L_0x001c:
        r2 = move-exception;
    L_0x001d:
        com.ucweb.common.util.o.a.a(r1);
    L_0x0020:
        return r0;
    L_0x0021:
        r2 = r2.digest();	 Catch:{ FileNotFoundException -> 0x001c, IOException -> 0x003d, Throwable -> 0x003b }
        r0 = a(r2);	 Catch:{ FileNotFoundException -> 0x001c, IOException -> 0x003d, Throwable -> 0x003b }
        r1.close();	 Catch:{ IOException -> 0x002d, FileNotFoundException -> 0x001c, Throwable -> 0x003b }
        goto L_0x0020;
    L_0x002d:
        r1 = move-exception;
        goto L_0x0020;
    L_0x002f:
        r1 = move-exception;
        r1 = r0;
    L_0x0031:
        com.ucweb.common.util.o.a.a(r1);
        goto L_0x0020;
    L_0x0035:
        r1 = move-exception;
        r1 = r0;
    L_0x0037:
        com.ucweb.common.util.o.a.a(r1);
        goto L_0x0020;
    L_0x003b:
        r2 = move-exception;
        goto L_0x0037;
    L_0x003d:
        r2 = move-exception;
        goto L_0x0031;
    L_0x003f:
        r1 = move-exception;
        r1 = r0;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.b.b.b.a(java.io.File):java.lang.String");
    }

    public static String a(String str) {
        String str2 = null;
        if (str != null) {
            try {
                byte[] bytes = str.getBytes();
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bytes);
                str2 = a(instance.digest());
            } catch (Exception e) {
            }
        }
        return str2;
    }

    public static byte[] b(String str) {
        byte[] bArr = null;
        if (str != null) {
            try {
                byte[] bytes = str.getBytes();
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bytes);
                bArr = instance.digest();
            } catch (Exception e) {
            }
        }
        return bArr;
    }

    public static String c(String str) {
        try {
            return com.ucweb.common.util.k.b.a(MessageDigest.getInstance("md5").digest(str.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (UnsupportedEncodingException e2) {
            return "";
        }
    }
}
