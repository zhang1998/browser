package com.ucpro.feature.i.a;

import android.annotation.TargetApi;
import android.view.Window;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
final class n implements k {
    n() {
    }

    @TargetApi(21)
    public final void a(Window window, int i) {
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(SectionHeader.SHT_LOUSER);
        window.setStatusBarColor(i);
    }
}
