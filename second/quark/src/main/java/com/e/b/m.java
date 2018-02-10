package com.e.b;

import android.text.TextUtils;
import com.uc.apollo.impl.SettingsConst;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class m {
    public String a = null;
    public String b = null;
    public String c = null;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public String g = null;
    public String h = null;
    public String i = null;

    public final Map<String, String> a(boolean z) {
        Map<String, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.a)) {
            hashMap.put("spm-cnt", this.a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            hashMap.put("spm-url", this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            hashMap.put("spm-pre", this.c);
        }
        if (this.f) {
            hashMap.put("isbf", SettingsConst.TRUE);
        } else if (this.e && z) {
            hashMap.put("isfm", SettingsConst.TRUE);
        } else if (this.d) {
            hashMap.put("ut_isbk", SettingsConst.TRUE);
        }
        if (!TextUtils.isEmpty(this.g)) {
            hashMap.put("utparam-cnt", this.g);
        }
        if (!TextUtils.isEmpty(this.h)) {
            hashMap.put("utparam-url", this.h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            hashMap.put("utparam-pre", this.i);
        }
        return hashMap;
    }
}
