package com.ui.edittext;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class m implements OnClickListener {
    final /* synthetic */ u a;
    final /* synthetic */ TextView b;

    m(TextView textView, u uVar) {
        this.b = textView;
        this.a = uVar;
    }

    public final void onClick(View view) {
        if (this.b.k != null) {
            this.b.k.a((c) view.getTag(), this.a);
        }
    }
}
