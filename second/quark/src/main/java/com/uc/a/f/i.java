package com.uc.a.f;

import android.text.TextUtils;
import com.uc.a.d;
import com.uc.a.f;
import com.uc.a.j;
import com.uc.base.b.c.c.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class i implements d {
    final /* synthetic */ a a;

    i(a aVar) {
        this.a = aVar;
    }

    public final void a(f fVar) {
        HashMap hashMap = (HashMap) fVar.d;
        if (hashMap != null) {
            if (TextUtils.isEmpty((String) hashMap.get("us_srv_url_https"))) {
                hashMap.get("us_srv_url");
            }
            a.a((String) hashMap.get("cd_recycle"), j.b);
            Object obj = null;
            for (Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                new StringBuilder("[dispatcher] request result: ").append(str).append("=").append(str2);
                j jVar = this.a.c;
                if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                    jVar.a.edit().putString(str, str2).apply();
                }
                obj = 1;
            }
            if (obj != null) {
                j jVar2 = this.a.c;
                jVar2.a.edit().putLong("__last_update", System.currentTimeMillis()).apply();
                Iterator it = this.a.d.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).a(this.a);
                }
            }
        }
    }
}
