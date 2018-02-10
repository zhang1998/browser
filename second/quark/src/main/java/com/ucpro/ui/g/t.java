package com.ucpro.ui.g;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class t implements OnClickListener {
    final /* synthetic */ g a;

    t(g gVar) {
        this.a = gVar;
    }

    public final void onClick(View view) {
        if (this.a.a.isSelected()) {
            this.a.a.setSelected(false);
        } else {
            this.a.a.setSelected(true);
        }
    }
}
