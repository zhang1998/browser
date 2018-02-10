package com.uc.base.a.a.a.e;

import android.text.TextUtils;
import com.uc.base.a.a.a.d.a;
import com.uc.base.a.a.a.d.b;
import java.util.TreeMap;

/* compiled from: ProGuard */
final class p implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ c d;
    final /* synthetic */ j e;

    p(j jVar, String str, String str2, String str3, c cVar) {
        this.e = jVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = cVar;
    }

    public final void run() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("method", "cas.loginWithThirdPartyAccount");
        treeMap.put("third_party_name", this.a);
        treeMap.put("third_party_token", this.b);
        if (!TextUtils.isEmpty(this.c)) {
            treeMap.put("open_id", this.c);
        }
        b a = a.a(treeMap);
        if (this.d != null) {
            this.e.b(new q(this, a));
        }
    }
}
