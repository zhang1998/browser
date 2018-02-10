package com.taobao.weex.ui.component;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/* compiled from: ProGuard */
final class af implements OnClickListener {
    final /* synthetic */ ImageView a;
    final /* synthetic */ aj b;
    final /* synthetic */ ag c;

    af(ag agVar, ImageView imageView, aj ajVar) {
        this.c = agVar;
        this.a = imageView;
        this.b = ajVar;
    }

    public final void onClick(View view) {
        this.a.setOnClickListener(null);
        this.a.setEnabled(false);
        this.b.b();
    }
}
