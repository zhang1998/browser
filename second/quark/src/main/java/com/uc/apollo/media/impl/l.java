package com.uc.apollo.media.impl;

import com.UCMobile.Apollo.MediaPlayer.IRequestExternalValueListener;
import com.uc.apollo.Settings;

/* compiled from: ProGuard */
final class l implements IRequestExternalValueListener {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public final String getStringValue(int i, String str) {
        return Settings.getStringValue(str);
    }

    public final float getFloatValue(int i, String str) {
        return Settings.getFloatValue(str);
    }

    public final int getIntValue(int i, String str) {
        return Settings.getIntValue(str);
    }
}
