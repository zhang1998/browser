package com.ucpro.feature.video.player.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.uc.webview.export.internal.setup.UCMPackageInfo;

/* compiled from: ProGuard */
final class g implements OnClickListener {
    final /* synthetic */ u a;

    g(u uVar) {
        this.a = uVar;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case 31:
                this.a.i.a(UCMPackageInfo.getLibFilter, null, null);
                return;
            case 34:
                this.a.i.a(10091, null, null);
                return;
            default:
                return;
        }
    }
}
