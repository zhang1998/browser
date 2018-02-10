package com.ucpro.feature.collectpanel.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class h implements OnClickListener {
    final /* synthetic */ InputTextBox a;

    h(InputTextBox inputTextBox) {
        this.a = inputTextBox;
    }

    public final void onClick(View view) {
        this.a.b.setText((CharSequence) "");
    }
}
