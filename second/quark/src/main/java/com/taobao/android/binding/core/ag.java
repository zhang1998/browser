package com.taobao.android.binding.core;

import android.util.Pair;
import android.view.View;
import com.taobao.weex.utils.ah;
import java.util.Map;

/* compiled from: ProGuard */
final class ag implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ View b;
    final /* synthetic */ Object c;
    final /* synthetic */ ah d;

    ag(ah ahVar, Map map, View view, Object obj) {
        this.d = ahVar;
        this.a = map;
        this.b = view;
        this.c = obj;
    }

    public final void run() {
        Pair a = as.a(ah.a(this.a.get("transformOrigin"), null), this.b);
        if (a != null) {
            this.b.setPivotX(((Float) a.first).floatValue());
            this.b.setPivotY(((Float) a.second).floatValue());
        }
        this.b.setScaleX((float) ((Double) this.c).doubleValue());
    }
}
