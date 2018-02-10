package com.ucweb.common.util.d;

import android.text.TextUtils;
import java.io.IOException;

/* compiled from: ProGuard */
public enum b {
    XIAOMI("xiaomi"),
    HUAWEI("huawei"),
    HONOR("honor"),
    SAMSUNG("samsung"),
    MEIZU("meizu"),
    VIVO("vivo"),
    COOLPAD("coolpad"),
    OPPO("oppo"),
    MOTO("moto"),
    NUBIA("nubia"),
    UNKNOWN("unknown");
    
    private String l;
    private String m;

    private b(String str) {
        this.l = str.toLowerCase();
    }

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        String toLowerCase = str.toLowerCase();
        for (b bVar : values()) {
            if (toLowerCase.contains(bVar.l)) {
                break;
            }
        }
        b bVar2 = null;
        if (bVar2 == XIAOMI) {
            try {
                Object a = c.a().a("ro.miui.ui.version.name", "");
                if (!TextUtils.isEmpty(a)) {
                    bVar2 = XIAOMI;
                    bVar2.m = a;
                }
            } catch (IOException e) {
                bVar2 = UNKNOWN;
            }
        }
        if (bVar2 == null) {
            return UNKNOWN;
        }
        return bVar2;
    }
}
