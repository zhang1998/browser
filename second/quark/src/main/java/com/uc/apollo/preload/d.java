package com.uc.apollo.preload;

import com.UCMobile.Apollo.MediaPreload.IPreloadListener;

/* compiled from: ProGuard */
final class d implements IPreloadListener {
    final /* synthetic */ PreloadListener a;

    d(PreloadListener preloadListener) {
        this.a = preloadListener;
    }

    public final void onInfo(String str, int i, int i2) {
        this.a.onInfo(str, i, i2);
    }
}
