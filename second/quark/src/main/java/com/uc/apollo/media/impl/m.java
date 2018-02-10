package com.uc.apollo.media.impl;

import com.UCMobile.Apollo.MediaPlayer;
import com.UCMobile.Apollo.MediaPlayer.OnVideoSizeChangedListener;

/* compiled from: ProGuard */
final class m implements OnVideoSizeChangedListener {
    final /* synthetic */ h a;

    m(h hVar) {
        this.a = hVar;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        new StringBuilder("onVideoSizeChanged, width/height ").append(i).append("/").append(i2);
        this.a.r.a(this.a.j, mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
    }
}
