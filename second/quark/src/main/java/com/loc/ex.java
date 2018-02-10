package com.loc;

import com.uc.apollo.impl.SettingsConst;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class ex extends bp {
    private byte[] a;
    private String b = SettingsConst.TRUE;

    public ex(byte[] bArr) {
        this.a = (byte[]) bArr.clone();
    }

    public ex(byte[] bArr, String str) {
        this.a = (byte[]) bArr.clone();
        this.b = str;
    }

    public final Map<String, String> a() {
        return null;
    }

    public final Map<String, String> b() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.a.length));
        return hashMap;
    }

    public final String c() {
        String str = er.b;
        Object[] objArr = new Object[5];
        objArr[0] = SettingsConst.TRUE;
        objArr[1] = this.b;
        objArr[2] = SettingsConst.TRUE;
        objArr[3] = "open";
        Object a = eq.a(er.a);
        Object obj = new byte[(a.length + 50)];
        System.arraycopy(this.a, 0, obj, 0, 50);
        System.arraycopy(a, 0, obj, 50, a.length);
        objArr[4] = eq.d(ek.a(obj, "MD5"));
        return String.format(str, objArr);
    }

    public final byte[] e() {
        return this.a;
    }
}
