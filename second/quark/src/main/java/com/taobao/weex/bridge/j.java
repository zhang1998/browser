package com.taobao.weex.bridge;

import java.util.ArrayList;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ Object[] a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ s d;

    j(s sVar, Object[] objArr, String str, String str2) {
        this.d = sVar;
        this.a = objArr;
        this.b = str;
        this.c = str2;
    }

    public final void run() {
        if (this.a != null && this.a.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (Object add : this.a) {
                arrayList.add(add);
            }
            t tVar = new t();
            tVar.put("method", this.b);
            tVar.put("args", arrayList);
            if (this.d.h.get(this.c) == null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(tVar);
                this.d.h.put(this.c, arrayList2);
                return;
            }
            ((ArrayList) this.d.h.get(this.c)).add(tVar);
        }
    }
}
