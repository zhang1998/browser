package com.ucpro.feature.collectpanel.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class d implements OnClickListener {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void onClick(View view) {
        if (this.a.d.a) {
            this.a.d.setSelected(!this.a.d.isSelected());
        }
    }
}
