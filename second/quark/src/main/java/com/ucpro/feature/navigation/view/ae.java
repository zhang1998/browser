package com.ucpro.feature.navigation.view;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: ProGuard */
final class ae implements OnLongClickListener {
    final /* synthetic */ j a;

    ae(j jVar) {
        this.a = jVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.j != null) {
            this.a.j.a(this.a, 4);
        }
        return true;
    }
}
