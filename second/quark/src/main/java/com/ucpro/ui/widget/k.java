package com.ucpro.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class k implements OnClickListener {
    final /* synthetic */ TextCheckBox a;

    k(TextCheckBox textCheckBox) {
        this.a = textCheckBox;
    }

    public final void onClick(View view) {
        if (this.a.a.isSelected()) {
            this.a.a.setSelected(false);
        } else {
            this.a.a.setSelected(true);
        }
        if (this.a.c != null) {
            this.a.c.a(this.a.a.isSelected());
        }
    }
}
