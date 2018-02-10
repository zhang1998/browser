package com.ucpro.base.c.b;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
final class b implements OnHierarchyChangeListener {
    final /* synthetic */ t a;

    b(t tVar) {
        this.a = tVar;
    }

    public final void onChildViewRemoved(View view, View view2) {
        c.b(!this.a.j);
    }

    public final void onChildViewAdded(View view, View view2) {
        c.b(!this.a.j);
    }
}
