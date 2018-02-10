package com.taobao.android.binding.core;

import android.util.Pair;
import android.view.View;
import com.taobao.weex.utils.ah;
import java.util.Map;

/* compiled from: ProGuard */
final class ai implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ View b;
    final /* synthetic */ Object c;
    final /* synthetic */ aj d;

    ai(aj ajVar, Map map, View view, Object obj) {
        this.d = ajVar;
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
        this.b.setScaleY((float) ((Double) this.c).doubleValue());
    }
}
