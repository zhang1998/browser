package com.uc.apollo.media.impl;

import com.UCMobile.Apollo.MediaPlayer.IRequestExternalValueListener;

/* compiled from: ProGuard */
final class j implements IRequestExternalValueListener {
    private IRequestExternalValueListener a = new k(this);
    private IRequestExternalValueListener b = new l(this);

    j() {
    }

    private IRequestExternalValueListener a(int i) {
        return i == 1 ? this.b : this.a;
    }

    public final float getFloatValue(int i, String str) {
        return a(i).getFloatValue(i, str);
    }

    public final int getIntValue(int i, String str) {
        return a(i).getIntValue(i, str);
    }

    public final String getStringValue(int i, String str) {
        return a(i).getStringValue(i, str);
    }
}
