package com.ucpro.feature.collectpanel.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.ucweb.common.util.f;

/* compiled from: ProGuard */
final class e implements OnClickListener {
    final /* synthetic */ InputTextBox a;

    e(InputTextBox inputTextBox) {
        this.a = inputTextBox;
    }

    public final void onClick(View view) {
        this.a.b.requestFocus();
        f.c(this.a.b.getContext());
        if (this.a.b.getText() != null && this.a.b.getText().length() >= 0) {
            this.a.b.setSelection(this.a.b.getText().length());
        }
        InputTextBox.d(this.a);
    }
}
