package com.taobao.weex.ui.component;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: ProGuard */
final class v implements OnFocusChangeListener {
    final /* synthetic */ ab a;

    v(ab abVar) {
        this.a = abVar;
    }

    public final void onFocusChange(View view, boolean z) {
        for (aa aaVar : this.a.mFocusChangeListeners) {
            if (aaVar != null) {
                aaVar.a(z);
            }
        }
    }
}
