package com.taobao.weex.d;

import com.uc.apollo.impl.SettingsConst;
import java.util.Map;

/* compiled from: ProGuard */
final class c {
    String a;
    String b;
    Map<String, String> c;
    byte[] d;
    b e;
    int f;

    private c(String str, String str2, Map<String, String> map, byte[] bArr, b bVar, int i) {
        this.e = b.text;
        this.f = SettingsConst.SDK_SETTINGS;
        this.a = str;
        this.b = str2;
        this.c = map;
        this.d = bArr;
        this.e = bVar;
        if (i == 0) {
            i = SettingsConst.SDK_SETTINGS;
        }
        this.f = i;
    }
}
