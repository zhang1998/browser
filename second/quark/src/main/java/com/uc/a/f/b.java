package com.uc.a.f;

import android.text.TextUtils;
import android.util.Log;
import com.uc.base.b.b.a;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class b {
    HashMap<String, String> a = new HashMap();

    public final boolean a(byte[] bArr) {
        if (bArr.length < 8 || (((bArr[0] << 8) & 65280) | (bArr[1] & 255)) != 4) {
            return false;
        }
        if (!"data".equals(new String(bArr, 2, 4).toLowerCase()) || (((bArr[6] << 8) & 65280) | (bArr[7] & 255)) <= 0) {
            return false;
        }
        com.uc.base.b.c.a.b a = a.a((byte) 1, (byte) 1);
        if (a == null) {
            return false;
        }
        byte[] a2 = a.a(bArr, 8);
        if (a2 == null) {
            return false;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(a2));
        Map hashMap = new HashMap();
        while (dataInputStream.available() > 0) {
            try {
                byte[] bArr2 = new byte[dataInputStream.readShort()];
                dataInputStream.readFully(bArr2);
                Object str = new String(bArr2, "ISO-8859-1");
                bArr2 = new byte[dataInputStream.readShort()];
                dataInputStream.readFully(bArr2);
                String str2 = new String(bArr2, "ISO-8859-1");
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put(str.toLowerCase(), str2);
                }
            } catch (Throwable e) {
                Log.e("DispatcherResponse", "decode error", e);
                return false;
            } catch (Throwable e2) {
                Log.e("DispatcherResponse", "decode error", e2);
                return false;
            } catch (Throwable e22) {
                Log.e("DispatcherResponse", "decode error", e22);
                return false;
            }
        }
        this.a.putAll(hashMap);
        return true;
    }
}
