package com.uc.apollo.media.impl;

import com.UCMobile.Apollo.MediaPlayer;
import com.UCMobile.Apollo.MediaPlayer.OnBufferingUpdateListener;
import com.uc.apollo.Settings;

/* compiled from: ProGuard */
final class q implements OnBufferingUpdateListener {
    final /* synthetic */ h a;

    q(h hVar) {
        this.a = hVar;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (!Settings.shouldCompatibleWithSystemMediaPlayer()) {
            this.a.r.a(this.a.j, 54, i, null);
        }
    }
}
