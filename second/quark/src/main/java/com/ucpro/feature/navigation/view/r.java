package com.ucpro.feature.navigation.view;

import android.graphics.Rect;
import android.view.View;

/* compiled from: ProGuard */
final class r implements ah {
    final /* synthetic */ aq a;

    r(aq aqVar) {
        this.a = aqVar;
    }

    public final void a(View view, Rect rect) {
        aq aqVar = this.a;
        aqVar.getLocationInWindow(aqVar.e);
        int i = aqVar.e[0];
        int i2 = aqVar.e[1];
        view.getLocationInWindow(aqVar.e);
        i = aqVar.e[0] - i;
        int i3 = aqVar.e[1] - i2;
        rect.set(i, i3, view.getMeasuredWidth() + i, view.getMeasuredHeight() + i3);
    }
}
