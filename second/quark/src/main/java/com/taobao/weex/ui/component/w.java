package com.taobao.weex.ui.component;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class w implements OnClickListener {
    final /* synthetic */ ab a;

    w(ab abVar) {
        this.a = abVar;
    }

    public final void onClick(View view) {
        if (this.a.mGesture == null || !this.a.mGesture.b) {
            for (z zVar : this.a.mHostClickListeners) {
                if (zVar != null) {
                    zVar.a();
                }
            }
        }
    }
}
