package com.taobao.android.binding.core;

import android.util.Pair;
import android.view.View;
import com.taobao.weex.utils.ah;
import java.util.Map;

/* compiled from: ProGuard */
final class aa implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ View b;
    final /* synthetic */ Object c;
    final /* synthetic */ ab d;

    aa(ab abVar, Map map, View view, Object obj) {
        this.d = abVar;
        this.a = map;
        this.b = view;
        this.c = obj;
    }

    public final void run() {
        int a = ((int) ((this.b.getContext().getApplicationContext().getResources().getDisplayMetrics().density * ((float) ah.b(this.a.get("perspective")))) * 5.0f));
        Pair a2 = as.a(ah.a(this.a.get("transformOrigin"), null), this.b);
        if (a != 0) {
            this.b.setCameraDistance((float) a);
        }
        if (a2 != null) {
            this.b.setPivotX(((Float) a2.first).floatValue());
            this.b.setPivotY(((Float) a2.second).floatValue());
        }
        this.b.setRotationX((float) ((Double) this.c).doubleValue());
    }
}
