package com.ucweb.c.c.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.ucweb.c.d.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.security.MessageDigest;

/* compiled from: ProGuard */
public final class b {
    static boolean a(String str) {
        if (str != null) {
            return new File(str).exists();
        }
        return false;
    }

    static String a(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    static byte[] b(String str) {
        Bitmap c = c.c(str);
        if (c == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        c.recycle();
        try {
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Exception e) {
            return toByteArray;
        }
    }

    public static boolean a() {
        return WXAPIFactory.createWXAPI(com.ucweb.c.c.b.a(), null).isWXAppInstalled();
    }
}
