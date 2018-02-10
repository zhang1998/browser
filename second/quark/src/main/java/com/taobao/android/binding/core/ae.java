package com.taobao.android.binding.core;

import android.util.Pair;
import android.view.View;
import com.taobao.weex.utils.ah;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: ProGuard */
final class ae implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ View b;
    final /* synthetic */ Object c;
    final /* synthetic */ af d;

    ae(af afVar, Map map, View view, Object obj) {
        this.d = afVar;
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
        double doubleValue;
        if (this.c instanceof Double) {
            doubleValue = ((Double) this.c).doubleValue();
            this.b.setScaleX((float) doubleValue);
            this.b.setScaleY((float) doubleValue);
        } else if (this.c instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) this.c;
            if (arrayList.size() >= 2 && (arrayList.get(0) instanceof Double) && (arrayList.get(1) instanceof Double)) {
                double doubleValue2 = ((Double) arrayList.get(0)).doubleValue();
                doubleValue = ((Double) arrayList.get(1)).doubleValue();
                this.b.setScaleX((float) doubleValue2);
                this.b.setScaleY((float) doubleValue);
            }
        }
    }
}
