package com.ucpro.feature.video.player.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class i implements OnClickListener {
    final /* synthetic */ k a;

    i(k kVar) {
        this.a = kVar;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case 13:
                this.a.p.a(10002, null, null);
                return;
            case 46:
                this.a.p.a(10100, null, null);
                return;
            default:
                return;
        }
    }
}
