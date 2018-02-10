package com.uc.apollo.media.impl;

import com.UCMobile.Apollo.MediaPlayer;
import com.UCMobile.Apollo.MediaPlayer.OnInfoListener;
import com.uc.apollo.Settings;

/* compiled from: ProGuard */
final class s implements OnInfoListener {
    final /* synthetic */ h a;

    s(h hVar) {
        this.a = hVar;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 607 && Settings.shouldCompatibleWithSystemMediaPlayer()) {
            this.a.r.a(this.a.j, 54, i2, null);
        }
        this.a.r.c(this.a.j, i, i2);
        return true;
    }
}
