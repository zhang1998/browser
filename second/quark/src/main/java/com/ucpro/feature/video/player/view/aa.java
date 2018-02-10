package com.ucpro.feature.video.player.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.ucpro.feature.video.player.a.b;

/* compiled from: ProGuard */
final class aa implements OnClickListener {
    final /* synthetic */ af a;

    aa(af afVar) {
        this.a = afVar;
    }

    public final void onClick(View view) {
        b a = b.a().a(6, view.getTag());
        if (view.getParent() == this.a.b) {
            this.a.p.a(10073, a, null);
        } else {
            this.a.p.a(10081, a, null);
        }
    }
}
