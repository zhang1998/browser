package com.uc.base.a.a.a.e;

import android.text.TextUtils;
import com.uc.base.a.a.a.d.a;
import java.util.TreeMap;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ a d;
    final /* synthetic */ j e;

    b(j jVar, String str, String str2, String str3, a aVar) {
        this.e = jVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = aVar;
    }

    public final void run() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("method", "cas.sendSmsCodeForLogin");
        treeMap.put("mobile", this.a);
        if (!(TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c))) {
            treeMap.put("captcha_id", this.b);
            treeMap.put("captcha_code", this.c);
        }
        com.uc.base.a.a.a.d.b a = a.a(treeMap);
        if (this.d != null) {
            this.e.b(new k(this, a));
        }
    }
}
