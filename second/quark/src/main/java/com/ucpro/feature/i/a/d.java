package com.ucpro.feature.i.a;

import android.annotation.TargetApi;
import android.view.View;
import android.view.Window;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
final class d implements k {
    d() {
    }

    @TargetApi(23)
    public final void a(Window window, int i) {
        window.clearFlags(67108864);
        window.addFlags(SectionHeader.SHT_LOUSER);
        window.setStatusBarColor(i);
        View findViewById = window.findViewById(16908290);
        if (findViewById != null) {
            findViewById.setForeground(null);
        }
    }
}
