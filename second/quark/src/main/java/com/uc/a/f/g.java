package com.uc.a.f;

import android.util.Base64;
import com.uc.a.k;
import com.uc.base.b.b.a;
import com.uc.base.b.c.a.b;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class g extends k {
    private byte[] d = null;

    public g() {
        this.a.put("dispatcher_upload", new HashMap());
    }

    public final byte[] f() {
        if (this.d != null) {
            return this.d;
        }
        String str = "<assign data=\"";
        byte[] g = g();
        b a = a.a((byte) 1, (byte) 1);
        if (a != null) {
            Object encode = Base64.encode(a.a(g), 2);
            Object bytes = str.getBytes();
            Object bytes2 = "\" />".getBytes();
            byte[] bArr = new byte[((bytes.length + encode.length) + bytes2.length)];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            int length = bytes.length + 0;
            System.arraycopy(encode, 0, bArr, length, encode.length);
            System.arraycopy(bytes2, 0, bArr, encode.length + length, bytes2.length);
            return bArr;
        }
        throw new RuntimeException("can not get encrypt handler for type: 1");
    }

    private byte[] g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<assign ");
        HashMap a = a("dispatcher_upload");
        if (!(a == null || a.isEmpty())) {
            for (Entry entry : a.entrySet()) {
                stringBuilder.append(((String) entry.getKey()) + "=\"");
                stringBuilder.append(((String) entry.getValue()) + "\" ");
            }
        }
        stringBuilder.append("/>");
        try {
            this.d = stringBuilder.toString().getBytes("utf-8");
        } catch (Throwable e) {
            a.a(e);
        }
        return this.d;
    }
}
