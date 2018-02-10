package com.ucpro.feature.downloadpage.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class f implements OnClickListener {
    final /* synthetic */ k a;

    f(k kVar) {
        this.a = kVar;
    }

    public final void onClick(View view) {
        if (this.a.B != null) {
            this.a.dismiss();
            this.a.B.h();
        }
    }
}
