package com.ucpro.feature.video.player.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.uc.webview.export.internal.setup.UCMPackageInfo;

/* compiled from: ProGuard */
final class ao implements OnClickListener {
    final /* synthetic */ au a;

    ao(au auVar) {
        this.a = auVar;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case 27:
                this.a.p.a(UCMPackageInfo.getKernelFileIfMultiCoreFromDir, null, null);
                return;
            case 29:
                this.a.p.a(UCMPackageInfo.getLibFilter, null, null);
                return;
            case 43:
                this.a.p.a(10098, null, null);
                return;
            default:
                return;
        }
    }
}
