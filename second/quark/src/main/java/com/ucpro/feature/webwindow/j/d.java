package com.ucpro.feature.webwindow.j;

import android.webkit.ValueCallback;
import com.ucpro.business.stat.m;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ProGuard */
public final class d implements ValueCallback<CopyOnWriteArrayList<n>> {
    final /* synthetic */ r a;

    public d(r rVar) {
        this.a = rVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        int i;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) obj;
        if (copyOnWriteArrayList == null) {
            i = 0;
        } else {
            i = copyOnWriteArrayList.size();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("total_rule", String.valueOf(i));
        m.a("mannual_ad_block", "enter", hashMap);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            this.a.a.b();
            return;
        }
        this.a.c = copyOnWriteArrayList;
        new StringBuilder("onWindowShow, onReceiveValue\nadblockrulelist size is: ").append(copyOnWriteArrayList.size());
        this.a.a().c = this.a.c;
        this.a.a.a(this.a.a());
    }
}
