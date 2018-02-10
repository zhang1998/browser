package com.uc.c;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class f implements com.uc.f {
    public final void a() {
    }

    public final boolean a(String str) {
        File file = new File(str);
        if (!file.exists() || file.length() != c.b) {
            return false;
        }
        boolean z;
        Object obj = c.c;
        if (TextUtils.isEmpty(obj)) {
            z = false;
        } else {
            String a = a(file);
            if (a == null) {
                z = false;
            } else {
                z = a.equalsIgnoreCase(obj);
            }
        }
        if (z) {
            return true;
        }
        return false;
    }

    public final boolean b(String str) {
        return g.a(str);
    }

    private static String a(File file) {
        String str = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            try {
                InputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (Throwable e) {
                        throw new RuntimeException("Unable to process file for MD5", e);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                }
                str = new BigInteger(1, instance.digest()).toString(16);
                str = String.format("%32s", new Object[]{str}).replace(' ', '0');
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                }
            } catch (Throwable e4) {
                Log.e("VandaVideo", "Exception while getting FileInputStream", e4);
            }
        } catch (NoSuchAlgorithmException e5) {
        }
        return str;
    }
}
