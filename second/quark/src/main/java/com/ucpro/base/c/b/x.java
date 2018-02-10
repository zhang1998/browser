package com.ucpro.base.c.b;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

/* compiled from: ProGuard */
final class x implements OnHierarchyChangeListener {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public final void onChildViewAdded(View view, View view2) {
        this.a.setEnableGestureLimited(false);
        this.a.setEnableSwipeGesture(false);
    }

    public final void onChildViewRemoved(View view, View view2) {
        if (this.a.g.getChildCount() <= 1) {
            this.a.setEnableGestureLimited(true);
            this.a.setEnableSwipeGesture(true);
        }
    }
}
